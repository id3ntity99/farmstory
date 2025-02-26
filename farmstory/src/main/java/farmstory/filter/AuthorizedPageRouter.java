package farmstory.filter;

import java.io.IOException;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import farmstory.DataTransferObject;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * 사용자가 로그인한 경우, 사용자가 요청한 페이지에 대한 권한을 확인하는 필터. <br>
 * 예를 들어, 로그인한 사용자는 아이디/비밀번호 찾기, 회원가입 페이지 등으로 접속할 수 없다. 따라서 본 필터가 로그인한 사용자가 아이디/비밀번호 찾기, 회원가입 페이지
 * 등으로 접속할 수 없도록 막아준다.
 */
@WebFilter(urlPatterns = {"/order/*", "/article/write", "/wishlist/*", "/user/*"})
public class AuthorizedPageRouter extends HttpFilter {
  private static final long serialVersionUID = UUID.randomUUID().version();
  private static final Logger LOGGER =
      LoggerFactory.getLogger(AuthorizedPageRouter.class.getName());

  private String getRootPath(String uri) {
    int secondSeparatorIdx = uri.indexOf("/", uri.indexOf("/") + 1);
    return "/" + uri.substring(0, secondSeparatorIdx);
  }

  @Override
  protected void doFilter(HttpServletRequest request, HttpServletResponse response,
      FilterChain chain) throws IOException, ServletException {
    // 요청한 사용자가 로그인 상태인지 확인
    HttpSession session = request.getSession();
    DataTransferObject user = (DataTransferObject) session.getAttribute("sessUser");
    if (user == null) { // 로그인 하지 않은 사용자가 요청한 경우
      String msg =
          String.format("유효하지 않은 접근 (%s ==> %s)", request.getRemoteAddr(), request.getRequestURL());
      LOGGER.warn(msg);
      response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    } else { // 로그인한 사용자가 요청한 경우

      String uri = request.getRequestURI();

      // @WebFilter 어노테이션의 urlPatterns 변수 가져오기
      String[] urlPatterns = this.getClass().getAnnotation(WebFilter.class).urlPatterns();

      // Request URI의 root path 추출(ex. /user/*에서 /user 추출)
      String root = getRootPath(uri);

      // 로그인한 사용자의 Request가 유효한 페이지에 대한 요청인지를 확인
      for (String pattern : urlPatterns) {
        String patternRoot = getRootPath(pattern);

        // TODO Possibly vulnerable?
        if (patternRoot.contains(root)) {// 로그인한 사용자가 요청한 페이지로의 접근이 유효한 경우
          String msg = String.format("사용자가 요청한 페이지(%s)로의 접근이 유효함. %s로 라우팅...",
              request.getRequestURL(), request.getRequestURL());
          LOGGER.info(msg);
          chain.doFilter(request, response);
          break;
        } else { // 유효하지 않은 경우
          response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }

      }

    }
  }
}
