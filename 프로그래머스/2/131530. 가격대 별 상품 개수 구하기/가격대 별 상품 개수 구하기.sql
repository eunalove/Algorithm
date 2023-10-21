select (floor(price/10000))*10000 as PRICE_GROUP, count(floor(price/10000)) as PRODUCTS
from PRODUCT
group by floor(price/10000)
order by floor(price/10000);