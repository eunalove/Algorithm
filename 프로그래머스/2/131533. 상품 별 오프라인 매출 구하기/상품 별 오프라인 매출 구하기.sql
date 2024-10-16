select p.PRODUCT_CODE, p.price* sum(SALES_AMOUNT) as SALES from 
PRODUCT as p join OFFLINE_SALE as o
on p.PRODUCT_ID = o.PRODUCT_ID
group by p.PRODUCT_ID
order by SALES desc, p.PRODUCT_CODE