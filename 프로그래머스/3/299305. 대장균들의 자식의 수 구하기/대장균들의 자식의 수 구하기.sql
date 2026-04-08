select p.ID as ID, count(c.ID) as CHILD_COUNT
from ECOLI_DATA p LEFT JOIN ECOLI_DATA c
ON c.PARENT_ID = p.ID
group by p.ID
order by p.ID
;