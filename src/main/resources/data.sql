INSERT INTO pic VALUES ('{
  "img_001": { "url": "https://example.com/img1.jpg", "alt": "Front view" },
  "img_001": { "url": "https://example.com/img1.jpg", "alt": "Front view" },
  "img_002": { "url": "https://example.com/img2.jpg", "alt": "Side view" }
}'::jsonb);
INSERT INTO pic(images) VALUES ('{
  "img_001": { "url": "https://example.com/img1.jpg", "alt": "Front view" }
}'::jsonb);






SELECT * FROM pic WHERE images->'img_001'->>'alt'='Front view';
SELECT images->'img_001'->>'alt' FROM pic;