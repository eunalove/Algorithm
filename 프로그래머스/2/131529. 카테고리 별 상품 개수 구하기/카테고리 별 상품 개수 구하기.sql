select substr(PRODUCT_CODE, 1, 2) as CATEGORY, count(*) as PRODUCTS from PRODUCT
group by substr(PRODUCT_CODE, 1, 2)
order by PRODUCT_CODE