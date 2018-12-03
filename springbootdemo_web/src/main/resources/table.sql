use test;
drop table `t_student`;
create table `t_student` (
   `id` int(10) NOT NULL AUTO_INCREMENT,
   `name` varchar(25) NOT NULL,
   `number` varchar(25) NOT NULL,
   PRIMARY KEY (`id`)
 );
insert into `t_student` (`id`, `namt_e`, `number`) values('1','yh','121314');