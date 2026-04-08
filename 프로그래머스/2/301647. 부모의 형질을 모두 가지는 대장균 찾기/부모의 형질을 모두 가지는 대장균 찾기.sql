-- 코드를 작성해주세요

select c.ID as ID, c.GENOTYPE as GENOTYPE, p.GENOTYPE as PARENT_GENOTYPE
from ECOLI_DATA c JOIN ECOLI_DATA p
on c.PARENT_ID = p.ID 
where c.GENOTYPE & p.GENOTYPE = p.GENOTYPE
order by c.ID asc;
