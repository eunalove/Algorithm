select date_format(SALES_DATE, '%Y-%m-%d') as SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
from ONLINE_SALE
WHERE year(SALES_DATE) = 2022 AND month(SALES_DATE) = 3

union

select date_format(SALES_DATE, '%Y-%m-%d') as SALES_DATE, PRODUCT_ID, Null as USER_ID, SALES_AMOUNT
from OFFLINE_SALE 
WHERE year(SALES_DATE) = 2022 AND month(SALES_DATE) = 3

order by SALES_DATE, PRODUCT_ID, USER_ID