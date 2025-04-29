# JSONB Tutorial
## I.What is JSONB

JSONB (JSON Better) are just like json but we can store multiple data in a column of database and we have query to mainipulate it like like our context selecting a image by its id
## II.Basic command for JSONB
### I.	Inserting a JSONB
To insert it by sql we have to follow this:

INSERT INTO table VALUES ('{"a": { "Field": "data",
"Field": "data",… }'::jsonb);

When you finish writing the json always end it with a jsonb(::jsonb)

Example:
INSERT INTO pic VALUES ('{
"img_001": { "url": "https://example.com/img1.jpg", "alt": "Front view" },
"img_001": { "url": "https://example.com/img1.jpg", "alt": "Front view" },
"img_002": { "url": "https://example.com/img2.jpg", "alt": "Side view" }
}'::jsonb);

### II.	Selecting a data in JSONB
There are a few way to select a jsonb data but these are the syntax you should know
-	(->) means get object
-	(->>) means get the text value to compare something

Example:
SELECT images->'img_001'->>'alt' FROM pic

Result: Front View

But if we use this (->) in the alt section:
SELECT images->'img_001'->'alt' FROM pic

The result would be “Front View” instead
This is because using ->> means getting the value of the data itself unlike -> which only get the plain text

-we can also doing WHERE condition with it
Example:
SELECT * FROM pic WHERE images->'img_001'->>'alt'='Front view';

the results would be {"img_001": {"alt": "Front view", "url": "https://example.com/img1.jpg"}}