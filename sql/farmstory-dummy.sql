USE farmstory;

INSERT INTO `user` VALUES ("abc123", SHA2("abc@123", 256), "김철수", "뭘봐", 0, 0, "abc123@example.com", "010-1111-2222", "12345", "부산광역시 유엔평화로 1번길 2", "행복빌라 426호", NOW(), NULL);

INSERT INTO company VALUES (1, "화북과수원", "홍길동", "010-1234-5677", "경상북도 상주시 화북면");

DESCRIBE product_image;
INSERT INTO product_image VALUES (1, "/uploads/thumb1.jpg", "/uploads/thumb1.jpg", "/uploads/detail.jpg");
INSERT INTO product_image VALUES (2, "/uploads/thumb2.jpg", "/uploads/thumb2.jpg", "/uploads/detail.jpg");
INSERT INTO product_image VALUES (3, "/uploads/thumb3.jpg", "/uploads/thumb3.jpg", "/uploads/detail.jpg");
INSERT INTO product_image VALUES (4, "/uploads/thumb4.jpg", "/uploads/thumb4.jpg", "/uploads/detail.jpg");
INSERT INTO product_image VALUES (5, "/uploads/thumb5.jpg", "/uploads/thumb5.jpg", "/uploads/detail.jpg");
SELECT * FROM product_image;

DESCRIBE product;
INSERT INTO product VALUES (1, 1, "사과 100g", "과일", 4000, 4, 1.0, 2500, 23, 1, NOW());
INSERT INTO product VALUES (2, 1, "사과 200g", "과일", 5000, 5, 2.0, 2500, 33, 2, NOW());
INSERT INTO product VALUES (3, 1, "사과 300g", "과일", 6000, 6, 3.0, 2500, 43, 3, NOW());
INSERT INTO product VALUES (4, 1, "사과 400g", "과일", 7000, 7, 4.0, 2500, 13, 4, NOW());
INSERT INTO product VALUES (5, 1, "사과 500g", "과일", 8000, 8, 5.0, 2500, 73, 5, NOW());
SELECT * FROM product;


INSERT INTO article VALUES (1, "abc123", "글쓰기 테스트1", "뭘봐", "글쓰기 테스트 입니다1", 1, 1, 0, NOW());
INSERT INTO article VALUES (2, "abc123", "글쓰기 테스트2", "뭘봐", "글쓰기 테스트 입니다2", 1, 1, 0, NOW());
INSERT INTO article VALUES (3, "abc123", "글쓰기 테스트3", "뭘봐", "글쓰기 테스트 입니다3", 1, 1, 0, NOW());
INSERT INTO article VALUES (4, "abc123", "글쓰기 테스트4", "뭘봐", "글쓰기 테스트 입니다4", 1, 1, 0, NOW());
INSERT INTO article VALUES (5, "abc123", "글쓰기 테스트5", "뭘봐", "글쓰기 테스트 입니다5", 1, 1, 0, NOW());
SELECT * FROM article;

INSERT INTO article_file VALUES (1, 1, "/home/images/article/test1.jpg");
INSERT INTO article_file VALUES (2, 2, "/home/images/article/test2.jpg");
INSERT INTO article_file VALUES (3, 3, "/home/images/article/test3.jpg");
INSERT INTO article_file VALUES (4, 4, "/home/images/article/test4.jpg");
INSERT INTO article_file VALUES (5, 5, "/home/images/article/test5.jpg");
SELECT * FROM article_file;

INSERT INTO `comment` VALUES (1, 1, "뭘봐", "댓글 쓰기 테스트 입니다1", NOW());
INSERT INTO `comment` VALUES (2, 2, "뭘봐", "댓글 쓰기 테스트 입니다2", NOW());
INSERT INTO `comment` VALUES (3, 3, "뭘봐", "댓글 쓰기 테스트 입니다3", NOW());
INSERT INTO `comment` VALUES (4, 4, "뭘봐", "댓글 쓰기 테스트 입니다4", NOW());
INSERT INTO `comment` VALUES (5, 5, "뭘봐", "댓글 쓰기 테스트 입니다5", NOW());
SELECT * FROM `comment`;

INSERT INTO `term` VALUES (1, "이용약관", "이용약관 테스트 입니다.");
INSERT INTO `term` VALUES (2, "개인정보 처리방침", "개인정보 처리방침 테스트 입니다.");

SELECT
* 
FROM product AS prod
JOIN company AS comp
ON prod.company_id = comp.id
WHERE prod.id = 6;

SELECT 
prod.id,
comp.id AS company_id,
comp.company_name,
comp.manager_name,
comp.contact,
comp.addr,
prod.`name`,
prod.category,
prod.price,
prod.`point`,
prod.discount_rate,
prod.delivery_fee,
prod.stock,
image.id AS `image_id`,
image.thumbnail_location,
image.info_location,
image.detail_location,
prod.register_date
FROM `product` AS `prod` 
JOIN product_image AS image
ON prod.image_id = image.id
JOIN company AS comp
ON prod.company_id = comp.id
WHERE prod.id = 6

