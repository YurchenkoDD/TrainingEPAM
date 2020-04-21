select * from products
where title like '% AIRPORT'

select * from products
where category = 8 and price = 9.99 
order by category,price

select * from products 
where category in (8,15)

select * from products
where price between 10 and 20

select * from orders 
where DATE(orderdate) >= '2004-01-05' and DATE(orderdate) <= '2004-02-05'

select customerid, count(customerid) from orders
group by customerid
order by customerid; 

select customerid, orderdate, sum(totalamount) from orders
group by customerid, orderdate, totalamount
having totalamount > 100;

select c.firstname, c.lastname, p.title, o.orderdate from customers c
join orders o on o.customerid = c.customerid 
join orderlines ol on ol.orderid = o.orderid
join products p on p.prod_id = ol.prod_id;