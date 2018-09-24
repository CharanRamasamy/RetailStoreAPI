insert into student values(1,'Charan', 'E1234567');
insert into student values(2,'Thomas', 'A1234568');

insert into shop (SHOP_ID,SHOP_NAME,ADDRESS_LINE1,ADDRESS_LINE2,CITY,PROVINCE,COUNTRY,POSTALCODE,PHONE) values(1001,'Shopify','1030 Park Street','University Avenue','Toronto','Ontario','Canada','B2K 5H8','9034567654');
insert into shop (SHOP_ID,SHOP_NAME,ADDRESS_LINE1,ADDRESS_LINE2,CITY,PROVINCE,COUNTRY,POSTALCODE,PHONE) values(1002,'Flipkart','500 South Street','British Ave','Vancouver','British Columbia','Canada','A7R 5P9','9023426735');
insert into shop (SHOP_ID,SHOP_NAME,ADDRESS_LINE1,ADDRESS_LINE2,CITY,PROVINCE,COUNTRY,POSTALCODE,PHONE) values(1003,'Amazon','804 Barrington St','Coles Road','Waterloo','Ontario','Canada','B1F 8D9','9039087787');

insert into product (PRODUCT_ID,SHOP_ID,PRODUCT_NAME,PRODUCT_CATEGORY,PRODUCT_DESCRIPTION,PRODUCT_PRICE,QUANTITY_IN_STOCK) values (1001,1001,'Apple iPhone','Phone','Apple product version Xs',1580,75);
insert into product (PRODUCT_ID,SHOP_ID,PRODUCT_NAME,PRODUCT_CATEGORY,PRODUCT_DESCRIPTION,PRODUCT_PRICE,QUANTITY_IN_STOCK) values (1002,1001,'Samsung S9 Plus','Phone','Samsung Mobiles top product',1274,98);
insert into product (PRODUCT_ID,SHOP_ID,PRODUCT_NAME,PRODUCT_CATEGORY,PRODUCT_DESCRIPTION,PRODUCT_PRICE,QUANTITY_IN_STOCK) values (1003,1002,'Oneplus 7','Phone','Oneplus mobiles Inc.,',1280,147);
insert into product (PRODUCT_ID,SHOP_ID,PRODUCT_NAME,PRODUCT_CATEGORY,PRODUCT_DESCRIPTION,PRODUCT_PRICE,QUANTITY_IN_STOCK) values (1004,1003,'Note 6','Phone','Redmi Corporations',679,24);

insert into cart (ORDER_ID,SHOP_ID,ORDER_DATE,ORDER_TIME,ORDER_TOTAL) values (2343,1001,'2018-02-03','12:00:00',534);