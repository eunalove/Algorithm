select ID, 
case
    when SIZE_OF_COLONY <101 then 'LOW'
    when SIZE_OF_COLONY <1001 then 'MEDIUM'
    else 'HIGH'
end as SIZE
from ECOLI_DATA