USE farmstory;

DESCRIBE product;
INSERT INTO product VALUES (1, 1, "사과 100g", "과일", 4000, 4, 1.0, 2500, 23, 2, NOW());
INSERT INTO product VALUES (2, 1, "사과 200g", "과일", 5000, 5, 2.0, 2500, 33, 3, NOW());
INSERT INTO product VALUES (3, 1, "사과 300g", "과일", 6000, 6, 3.0, 2500, 43, 4, NOW());
INSERT INTO product VALUES (4, 1, "사과 400g", "과일", 7000, 7, 4.0, 2500, 13, 5, NOW());
INSERT INTO product VALUES (5, 1, "사과 500g", "과일", 8000, 8, 5.0, 2500, 73, 2, NOW());
SELECT * FROM product;

DESCRIBE product_image;
INSERT INTO product_image VALUES (1, 1, "/home/images/thumbnail/thumb1.jpg", "/home/images/info/info1.jpg", "/home/images/detail/detail1.jpg");
INSERT INTO product_image VALUES (2, 2, "/home/images/thumbnail/thumb2.jpg", "/home/images/info/info2.jpg", "/home/images/detail/detail2.jpg");
INSERT INTO product_image VALUES (3, 3, "/home/images/thumbnail/thumb3.jpg", "/home/images/info/info3.jpg", "/home/images/detail/detail3.jpg");
INSERT INTO product_image VALUES (4, 4, "/home/images/thumbnail/thumb4.jpg", "/home/images/info/info4.jpg", "/home/images/detail/detail4.jpg");
INSERT INTO product_image VALUES (5, 5, "/home/images/thumbnail/thumb5.jpg", "/home/images/info/info5.jpg", "/home/images/detail/detail5.jpg");
SELECT * FROM product_image;

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