select CATEGORY, PRICE as MAX_PRICE, PRODUCT_NAME
from FOOD_PRODUCT
where CATEGORY in ('과자', '국', '김치', '식용유')
AND PRICE in (select MAX(PRICE)
              from FOOD_PRODUCT
                group by CATEGORY
              )
order by price desc;