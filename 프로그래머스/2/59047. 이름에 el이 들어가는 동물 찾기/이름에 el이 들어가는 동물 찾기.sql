select ANIMAL_ID, NAME
from ANIMAL_INS
where ANIMAL_TYPE = "Dog"
and NAME like "%el%" or "%EL%"
order by NAME