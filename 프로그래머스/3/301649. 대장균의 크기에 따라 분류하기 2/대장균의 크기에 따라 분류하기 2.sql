select a.id as ID, 
    case 
        when a.PER <= 0.25 then 'CRITICAL'
        when a.PER <= 0.5 then 'HIGH'
        when a.PER <= 0.75 then 'MEDIUM'
        else 'LOW'
    END AS COLONY_NAME
from 
(
    select id, PERCENT_RANK() OVER(order by SIZE_OF_COLONY desc) as PER
    from ECOLI_DATA
) as a
order by a.id asc;