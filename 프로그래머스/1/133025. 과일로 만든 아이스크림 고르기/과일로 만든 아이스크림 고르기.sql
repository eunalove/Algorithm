SELECT ICECREAM_INFO.FLAVOR
from (FIRST_HALF inner join ICECREAM_INFO 
on ICECREAM_INFO.FLAVOR = FIRST_HALF.FLAVOR)
where TOTAL_ORDER > 3000 and
INGREDIENT_TYPE= 'fruit_based'
order by TOTAL_ORDER desc;
