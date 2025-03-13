select a.ID, count(b.ID) as CHILD_COUNT
from ecoli_data as a
left join ecoli_data as b
on a.ID= b.parent_id
group by a.ID