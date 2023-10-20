
SELECT car_type, count(*)
from CAR_RENTAL_COMPANY_CAR
where options like ('%시트%')
group by car_type
order by car_type;