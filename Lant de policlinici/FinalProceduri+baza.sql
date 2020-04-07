
create database if not exists policlinica;
use policlinica;

create table if not exists pacient(
cnp char(15) primary key, 
nume char(20), 
prenume char(20)
);

drop table if exists login;
create table if not exists login(
CNP char(15) primary key,
user char(30),
pass char(30),
admin char(1) #a - s - n
);

drop table if exists angajat;
create table if not exists angajat(
CNP char(15) primary key,
salariu_neg int,
numar_ore_total int,
foreign key(CNP) references login(CNP) ON DELETE CASCADE,
tip_orar bool #0 -> saptamanal , 1 -> lunar
);


drop table if exists medic;
create table if not exists medic(
CNP char(15) primary key,
grad char(10),
cod_parafa char(10),
titlu_stiintific char(10),
post_didactic char(10),
procent_servicii int,
foreign key (CNP) references angajat(CNP) ON DELETE CASCADE
);


create table if not exists istoric_pacient(
id_istoric int auto_increment primary key, cnp_medic char(15), cnp_pacient char(15), simptome char(100), diagnostic char(100), recomandari char(100), foreign key (cnp_medic) references medic(cnp), 
foreign key (cnp_pacient) references pacient(cnp));


drop table if exists servicii;
create table if not exists servicii(
id_serv int auto_increment primary key,
nume char(30),
pret int,
durata int
);

create table if not exists raport_analize(
id int auto_increment primary key, rezultat int, val_bin tinyint, cnp_asist char(15), id_istoric int, foreign key (id_istoric) references istoric_pacient(id_istoric)); 

create table if not exists ist_serv(
id_istoric int, id_serv int, foreign key (id_istoric) references istoric_pacient(id_istoric), foreign key (id_serv) references servicii(id_serv));

drop table if exists unitate_medicala;
create table if not exists unitate_medicala(
id_unit int auto_increment primary key,
denumire char(30),
adresa char(30)
);

drop table if exists program_unitate;
create table if not exists program_unitate(
id_unit int AUTO_INCREMENT primary key,
zi Date,
start_p TIME,
end_p TIME,
foreign key (id_unit) references unitate_medicala(id_unit) 
);

drop table if exists date_personale;
create table if not exists date_personale(
CNP char(15) primary key,
nume char(30),
prenume char(30),
adresa char(30),
telefon char(10),
email char(30),
cont_IBAN char(30),
nr_contract char(30),
data_angajarii DATE,
functie char(40),
foreign key(CNP) references login(CNP) ON DELETE CASCADE
);

drop table if exists program_ang_l;
create table if not exists program_ang_l(
id_program int auto_increment primary key,
CNP char(15),
zi DATE,
start_p TIME,
end_p TIME,
id_unit int,
foreign key(CNP) references angajat(CNP),
foreign key(id_unit) references unitate_medicala(id_unit)
);

drop table if exists asistent_medical;
create table if not exists asistent_medical(
CNP char(15) primary key,
tip char(10),
grad char(10),
foreign key (CNP) references angajat(CNP) ON DELETE CASCADE
);

drop table if exists specialitate;
create table if not exists specialitate(
id_spec int auto_increment primary key,
nume char(30)
);

drop table if exists competente;
create table if not exists competente(
id_comp int auto_increment primary key,
nume char(30)
);

drop table if exists programare;
create table if not exists programare(
data Date,
start_p Time,
end_p Time,
CNP_pacient char(15),
CNP_medic char(15),
id_prog int auto_increment primary key,
durata int,
id_unit int,
foreign key (CNP_pacient) references pacient(CNP),
foreign key (CNP_medic) references angajat(CNP),
foreign key(id_unit) references unitate_medicala(id_unit)
);



drop table if exists unit_ang;
create table if not exists unit_ang(
id_unit int,
CNP char(15),
ore int,
foreign key (id_unit) references unitate_medicala(id_unit),
foreign key (CNP) references angajat(CNP)
);
drop table if exists ist_serv;
create table if not exists ist_serv(
id_istoric int,
id_serv int,
foreign key(id_istoric) references istoric_pacient(id_istoric),
foreign key(id_serv) references servicii(id_serv)
);

drop table if exists prog_serv;
create table if not exists prog_serv(
id_prog int,
id_serv int,
foreign key (id_prog) references programare(id_prog),
foreign key (id_serv) references servicii(id_serv)
);

drop table if exists spec_serv;
create table if not exists spec_serv(
id_spec int,
id_serv int,
foreign key (id_spec) references specialitate(id_spec),
foreign key (id_serv) references servicii(id_serv)
);


drop table if exists comp_serv;
create table if not exists comp_serv(
id_comp int,
id_serv int,
foreign key (id_serv) references servicii(id_serv),
foreign key (id_comp) references competente(id_comp)
);

drop table if exists med_comp;
create table if not exists med_comp(
id_comp int,
CNP char(15),
foreign key (id_comp) references competente(id_comp),
foreign key (CNP) references medic(CNP)
);


drop table if exists unit_serv;
create table if not exists unit_serv(
id_unit int,
id_serv int,
foreign key(id_unit) references unitate_medicala(id_unit),
foreign key(id_serv) references servicii(id_serv)
);

create table if not exists concediu(
CNP char(15),
id_concediu int auto_increment primary key,
ziua Date,
foreign key(CNP) references angajat(CNP)
);


drop table if exists program_ang_s;
create table if not exists program_ang_s(
id_program int auto_increment primary key,
CNP char(15),
zi int,
start_p TIME,
end_p TIME,
id_unit int,
foreign key(CNP) references angajat(CNP),
foreign key(id_unit) references unitate_medicala(id_unit)
);

drop table if exists med_spec;
create table if not exists med_spec(
id_spec int,
CNP char(15),
foreign key (id_spec) references specialitate(id_spec),
foreign key (CNP) references medic(CNP)
);

drop table if exists istoric_servicii;
create table if not exists istoric_servicii(
CNP char(15),
id_serv int,
id_unit int,
luna char(15),
foreign key(id_unit) references unitate_medicala(id_unit),
foreign key(id_serv) references servicii(id_serv),
foreign key(CNP) references angajat(CNP)
);

create table if not exists concediu(
CNP char(15),
id_concediu int auto_increment primary key,
ziua Date,
foreign key(CNP) references angajat(CNP)
);


/*
Pana aici a  fost creeare tabelelor
de aici in jos e popularea lor
*/
insert into login(CNP,user,pass,admin) values 
("1","ZoicanDeni","123","s"),
("2","PopescuDan","forbal","a"),
("3","Bursuk","moldova","0"),
("4","VladBora","bihor","s"),
("5","CristiSerbu","pacan","a"),
("6","DenisaVamvu","sadu","0"),
("7","PopoviciMihai","real","s"),
("8","DenisDenis","denis","s"),
("9","VaruMiu","craiova","a"),
("10","UserReal","passReal","0");

insert into angajat (CNP,salariu_neg,numar_ore_total,tip_orar) values 
("1",200,30,1),
("2",3000,20,1),
("3",210,35,1),
("4",150,50,0),
("5",900,43,0),
("6",950,29,1),
("7",790,54,0),
("8",450,31,1),
("9",2220,25,0),
("10",2020,45,1);

insert into medic (CNP,grad,cod_parafa,titlu_stiintific,post_didactic,procent_servicii) values 
("1","Mare","1123","Dr mare","Medic1",20),
("2","Mic","223","Dr mic","Medic2",5),
("3","Mediu","423","Dr mediu","Medic3",20),
("4","Mare","143","Dr mediu","Medic2",51),
("5","Mic","133","Dr mic","Medic4",2);


insert into date_personale(CNP,nume,prenume,adresa,telefon,email,cont_IBAN,nr_contract,data_angajarii,functie) values
("1","Zoican","Denis","TarguJiu","0766446390","zoican_denis@yahoo.com","2222","23","2008-7-04","medic"),
("2","NumeMedic2","PrenumeMedic2","Iasi","0762482387","email1","cont_IBAN1","nr_contract1","2018-2-03","medic"),
("3","NumeMedic3","PrenumeMedic3","Gherla","numar2","email2","cont_IBAN2","nr_contract2","2012-3-04","medic"),
("4","NumeMedic4","PrenumeMedic4","Adresa3","numar3","email3","cont_IBAN3","nr_contract3","2010-4-23","medic"),
("5","NumeMedic5","PrenumeMedic5","Adresa4","numar4","email4","cont_IBAN4","nr_contract4","2012-5-19","medic"),
("6","NumeInpector","PrenumeInspector","Adresa5","numar5","email5","cont_IBAN5","nr_contract5","2014-6-02","inspector"),
("7","NumeAsistent","PrenumeAsistent","Adresa6","numar6","email6","cont_IBAN6","nr_contract6","2010-7-03","assitent"),
("8","Gabi","Ilies","Gherla","numar2","email2","cont_IBAN2","nr_contract2","2012-3-04","assistent"),
("9","Apostol","Catalin","Iasi","0762482387","email1","cont_IBAN1","nr_contract1","2018-2-03","receptioner"),
("10","Expert","Prenume3","Adresa3","numar3","email3","cont_IBAN3","nr_contract3","2010-4-23","expert");

insert into asistent_medical(CNP,tip,grad) values 
("6","Sef","Mare"),
("7","Sclav","Mic");



insert into unitate_medicala(id_unit,denumire,adresa) values 
(1,"SpitalulJovial","Aici"),
(2,"Sptal","Acolo"),
(3,"Spital Gorj","TGJIU"),
(4,"SPITALMOKA","MOKAVILLE"),
(5,"CATENA","VILLA");

insert into specialitate(id_spec,nume) values 
(1,"Oase"),
(2,"Organe"),
(3,"Par"),
(4,"Piele"),
(5,"Ochi");

insert into servicii(id_serv,nume,pret,durata) values 
(1,"TaiereBrat",200,5),
(2,"CusutOrgan",5,20),
(3,"TransferSange",23,55),
(4,"Injectie",2,2),
(5,"Amputare",44,34);

insert into competente(id_comp,nume) values 
(1,"Comp1"),
(2,"Comp2"),
(3,"Comp3"),
(4,"Comp4"),
(5,"Comp5");

insert into med_spec(CNP,id_spec) values 
(1,1),
(1,3),
(1,4),
(1,2),
(2,2),
(2,3),
(3,4),
(3,5),
(3,3),
(4,1),
(4,3),
(5,1);


insert into spec_serv(id_spec,id_serv) values 
(1,1),
(1,5),
(2,3),
(4,2),
(5,4),
(5,1);

insert into comp_serv(id_comp,id_serv) values 
(1,2),
(1,3),
(2,4),
(4,1),
(5,5),
(3,2);


insert into pacient (cnp,nume,prenume) values
("12","Goia","Vlad"),
("1","Garbou","Raul"),
("2","Ilies","Gabi"),
("3","Schlanger","Diana"),
("9","Cristi","Dormea"),
("4","Vlad","Bora"),
("6","Catalin","Fugea");


insert into istoric_pacient(id_istoric,CNP_medic,CNP_pacient,simptome,diagnostic,recomandari) values 
(1,"1","12","Raceala","Racit","NuMaiBea"),
(2,"2","1","Simp1","Boala1","Trat1"),
(3,"3","2","Simp2","Boala2","Trat2"),
(4,"2","6","Simp3","Boala2","Trat3"),
(5,"4","4","Simp3","Boala1","Trat4"),
(6,"5","3","Simp4","Boala3","Trat3"),
(7,"2","3","Simp1","Boala4","Trat1"),
(8,"3","9","Simp2","Boala3","Trat1");

insert into ist_serv(id_istoric,id_serv) values 
(1,2),
(1,3),
(2,2),
(2,1),
(3,5),
(3,4),
(4,4),
(4,2),
(5,1),
(5,2),
(5,3);

insert into istoric_servicii(CNP,id_unit,id_serv,luna) values 
("1",1,1,1),
("2",2,1,2),
("3",3,3,1),
("4",4,4,1),
("5",5,3,1),
("1",5,1,2),
("2",4,4,1),
("1",3,1,1),
("1",2,2,2),
("1",1,3,1),
("4",1,3,2),
("1",1,3,2),
("1",1,3,3),
("1",1,3,4),
("1",1,3,5),
("1",1,3,6),
("1",1,3,7),
("1",1,3,8),
("1",1,3,9),
("1",1,3,10),
("1",1,3,11),
("1",1,3,12),
("4",2,4,1);


insert into med_comp(CNP,id_comp) values 
("1",1),
("2",2),
("3",3),
("4",4),
("5",5),
("1",1),
("2",1),
("2",2),
("3",3),
("4",4);

insert into programare(data,start_p,end_p,CNP_medic,CNP_pacient,id_prog,durata,id_unit) values
("2007-5-04","08:50:30","12:22:22","1","2",1,50,1),
("2008-5-04","18:50:50","13:22:24","2","1",2,150,1),
("2010-5-04","10:50:30","16:12:42","3","3",3,30,2),
("2007-5-05","20:50:40","22:22:22","4","3",4,40,3),
("2007-5-06","16:50:30","18:32:27","5","1",5,70,4),
("2007-4-07","08:25:30","9:22:22","2","4",6,30,2),
("2007-6-12","09:30:30","11:22:27","2","4",7,20,1),
("2007-5-14","15:20:30","17:42:32","3","2",8,30,1);

insert into prog_serv(id_prog,id_serv) values 
(1,1),
(2,2),
(3,3),
(4,4),
(5,5),
(6,1),
(7,2),
(8,3),
(2,3),
(3,1);

insert into unit_ang (id_unit,CNP,ore) values
(1,1,2),
(2,2,3),
(3,3,4),
(1,4,2),
(5,5,2),
(1,6,2),
(2,7,2),
(3,8,1),
(4,9,2),
(5,10,1),
(1,2,2),
(2,3,2),
(3,1,3),
(4,3,2);

insert into unit_serv(id_unit,id_serv) values
(1,2),
(2,3),
(3,1),
(4,5),
(5,4),
(1,4),
(1,5),
(2,2),
(2,1),
(4,1);


insert into concediu(CNP,ziua) values 
("1","2007-05-05"),
("2","2007-05-05"),
("3","2007-05-05"),
("4","2007-05-05"),
("5","2007-05-05"),
("6","2007-05-05"),
("7","2007-05-05"),
("8","2007-05-05"),
("9","2007-05-05"),
("10","2007-05-05"),
("1","2008-05-05"),
("1","2018-02-25"),
("1","2018-05-15"),
("1","2019-02-05"),
("2","2007-05-05"),
("3","2007-05-05");

insert into program_ang_l(CNP,id_unit,zi,start_p,end_p) values 
("1",1,"2019-05-05","09:11:00","19:21:00"),
("2",2,"2019-05-05","09:23:00","19:31:00"),
("3",3,"2019-05-05","09:40:00","19:41:00"),
("4",4,"2019-05-05","09:03:00","19:01:00"),
("5",5,"2019-05-05","09:22:00","19:12:00"),
("6",1,"2019-05-05","09:50:00","19:13:00"),
("7",2,"2019-05-05","09:40:00","19:14:00"),
("8",3,"2019-05-05","09:30:00","19:15:00"),
("9",5,"2019-05-05","09:20:00","19:16:00"),
("10",4,"2019-05-05","09:10:00","19:17:00");

insert into program_ang_s(CNP,zi,start_p,end_p,id_unit) values 
("1",1,"09:11:00","12:13:00",1),
("2",1,"09:11:00","19:13:00",2),
("3",1,"09:11:00","19:43:00",3),
("4",1,"09:11:00","16:13:00",4),
("5",1,"09:11:00","19:13:00",5),
("6",1,"09:11:00","09:13:00",2),
("7",1,"09:11:00","13:13:00",2),
("8",1,"09:11:00","14:13:00",3),
("9",1,"09:11:00","19:13:00",4),
("10",1,"09:11:00","15:13:00",5),
("1",1,"09:11:00","15:13:00",5),
("1",2,"09:11:00","15:13:00",1),
("1",2,"09:11:00","15:13:00",1),
("1",5,"09:11:00","15:13:00",4),
("1",5,"09:11:00","15:13:00",4),
("1",5,"09:11:00","15:13:00",1);

insert into program_unitate(id_unit,zi,start_p,end_p) values
(1,"2019-05-05","09:11:00","19:23:00"),
(2,"2019-05-05","08:11:00","19:03:00"),
(3,"2019-05-05","05:21:00","19:16:00"),
(4,"2019-05-05","09:41:00","19:33:00"),
(5,"2019-05-05","09:51:00","19:43:00");

/*
* Popularea cu succes
*Mai jos vom avea procedurile 
*
*/

/*Proceduri Gabi */

DELIMITER //

 CREATE PROCEDURE isAdmin(IN CNP VARCHAR(15),IN pass VARCHAR(30))
BEGIN
	select admin from login where login.CNP=CNP && login.pass=pass;
END //

DELIMITER ;


DELIMITER //
 CREATE PROCEDURE addAdmin(IN CNP VARCHAR(15),IN user VARCHAR(30), IN pass VARCHAR(30))
BEGIN
declare aux char(15);
select cnp into aux from login where (login.CNP=CNP and login.user=user and login.pass=pass);
if (aux) then
	update login
		set 
			login.admin='a'
		where login.CNP=CNP and login.user=user and login.pass=pass;
else
	insert into login VALUES(CNP,user,pass,'a');
end if;
END //

DELIMITER ;


DELIMITER //
 CREATE PROCEDURE addCommonUserLogin(IN CNP VARCHAR(15),IN user VARCHAR(30), IN pass VARCHAR(30))
BEGIN
	insert into login VALUES(CNP,user,pass,'0');
END //

DELIMITER ;


DELIMITER //
 CREATE PROCEDURE addCommonUserDatePers(IN CNP VARCHAR(15),IN nume VARCHAR(30), IN prenume VARCHAR(30), IN adresa VARCHAR(30), IN telefon VARCHAR(10), 
 IN email VARCHAR(30),IN cont_IBAN VARCHAR(30),IN nr_contract VARCHAR(30), IN data_angajarii date, IN functie varchar(40))
BEGIN
	insert into date_personale(CNP,nume,prenume,adresa,telefon,email,cont_IBAN,nr_contract,data_angajarii,functie) values (CNP,nume,prenume,adresa,telefon,email,cont_IBAN,nr_contract,data_angajarii,functie);
END //

DELIMITER ;


DELIMITER //
 CREATE PROCEDURE addAngajat(IN CNP VARCHAR(15),IN salariu int(11), IN numarOre int(11),IN tipOrar tinyint(1))
BEGIN
	insert into angajat VALUES(CNP,salariu,numarOre,tipOrar);
END //

DELIMITER ;


DELIMITER //
 CREATE PROCEDURE addAsistent(IN CNP VARCHAR(15),IN tip char(10),IN grad char(10))
BEGIN
	insert into asistent_medical VALUES(CNP,tip,grad);
END //

DELIMITER ;


DELIMITER //
 CREATE PROCEDURE deleteAdmin(IN CNP VARCHAR(15),IN user VARCHAR(30), IN pass VARCHAR(30))
BEGIN
	update login l
		set 
			admin='0'
		where 
			l.CNP=CNP and l.user=user and l.pass=pass;
END //

DELIMITER ;

DELIMITER //
 CREATE PROCEDURE addMedic(IN CNP VARCHAR(15),IN grad char(10), IN cod_parafa char(10), IN titlu_stiintific char(10), IN post_didactic char(10), IN procent_servicii int(11))
BEGIN
	insert into medic VALUES(CNP,grad,cod_parafa,titlu_stiintific,post_didactic,procent_servicii);
END //

DELIMITER ;


DELIMITER //
 CREATE PROCEDURE deleteUser(IN CNP VARCHAR(15),IN user VARCHAR(30), IN pass VARCHAR(30))
BEGIN
declare aux char(15);
select CNP into aux from login where login.CNP=CNP and  login.pass=pass and login.user=user and login.admin='0';

if (aux) 
	then
    delete from programare where programare.CNP=CNP;
	delete from concediu where concediu.CNP=CNP;
	delete from program_ang_l where program_ang_l.CNP=CNP;
    delete from program_ang_s where program_ang_s.CNP=CNP;
    delete from asistent_medical where asistent_medical.CNP=CNP;
    delete from date_personale where date_personale.CNP=CNP;
    delete from medic where medic.CNP=CNP;
    delete from unit_ang where unit_ang.CNP=CNP;
    delete from med_comp where med_comp.CNP=CNP;
    delete from med_spec where med_spec.CNP=CNP;
	delete from angajat where angajat.CNP=CNP;
	delete from login where login.CNP=CNP and login.pass=pass and login.user=user;
    end if;
END //

DELIMITER ;


DELIMITER //
 CREATE PROCEDURE modifyLogin(IN CNP char(15),IN user char(30), IN pass char(30))
BEGIN
update login
	set
    login.user=user,
    login.pass=pass
    where login.cnp=cnp;
END //

DELIMITER ;


 DELIMITER //
 CREATE PROCEDURE modifyDatePers(IN CNP VARCHAR(15),IN nume VARCHAR(30), IN prenume VARCHAR(30), IN adresa VARCHAR(30), IN telefon VARCHAR(10), 
 IN email VARCHAR(30),IN cont_IBAN VARCHAR(30),IN nr_contract VARCHAR(30), IN data_angajarii date, IN functie varchar(40))
BEGIN
	update date_personale
    set
		date_personale.nume=nume,
        date_personale.prenume=prenume,
        date_personale.adresa=adresa,
        date_personale.telefon=telefon,
        date_personale.email=email,
        date_personale.cont_IBAN=cont_IBAN,
        date_personale.nr_contract=nr_contract,
        date_personale.data_angajarii=data_angajarii,
        date_personale.functie=functie
    where date_personale.CNP=CNP;
END //

DELIMITER ;



DELIMITER //
 CREATE PROCEDURE modifyAngajat(IN CNP VARCHAR(15),IN salariu int(11), IN numarOre int(11),IN tipOrar tinyint(1))
BEGIN
	update angajat
    set
    angajat.salariu_neg=salariu,
    angajat.numar_ore_total=numarOre,
    angajat.tip_orar=tipOrar
    where angajat.CNP=CNP;
END //

DELIMITER ;



DELIMITER //
 CREATE PROCEDURE addPoliclinica(IN id_unit int(11), denumire char(30), adresa char(30))
BEGIN
	insert into unitate_medicala values (id_unit,denumire,adresa);
END //

DELIMITER ;


DELIMITER //
 CREATE PROCEDURE getFunctie(IN CNP VARCHAR(15), IN pass VARCHAR(30))
BEGIN
	select functie from date_personale where date_personale.CNP = (select CNP from login where login.CNP=CNP and login.pass=pass);
END //

DELIMITER ;


DELIMITER //
 CREATE PROCEDURE parafareRaport(IN id_istoric int(11), IN cnp_asistent char(15))
BEGIN
	update istoric_pacient
    set 
		istoric_pacient.CNP_asist=cnp_asistent,
		istoric_pacient.val_bin='1'
	where istoric_pacient.id_istoric=id_istoric;
END //

DELIMITER ;


DELIMITER //
 CREATE PROCEDURE isParafat(IN id_istoric int(11))
BEGIN
	select val_bin from istoric_pacient where istoric_pacient.id_istoric=id_istoric;
END //

DELIMITER ;

/* Procedurile Gabrielei au fost compilate cu succes */

/* Proceduri Catalin */
DELIMITER //
CREATE PROCEDURE GetProfitMedic(IN CNP char(100))
BEGIN
	select a.salariu_neg + sum(s.pret*m.procent_servicii/100) AS profit from istoric_servicii i,angajat a,medic m,servicii s where i.CNP = CNP and i.id_serv = s.id_serv and m.CNP = CNP and a.CNP = CNP;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE InsertPacient(in CNP char(100),IN nume char(100),in prenume char(100))
BEGIN
	insert into pacient (CNP,nume,prenume) Values (CNP,nume,prenume);
END //
DELIMITER ;



DELIMITER //
 CREATE PROCEDURE creareProgramUnitate(IN id_unit int(11),IN zi date,IN start_p time,IN end_p time)
BEGIN
	insert into program_unitate values(id_unit, zi, start_p, end_p);
END //

DELIMITER ;


DELIMITER //
 CREATE PROCEDURE getFunctieBack(IN CNP VARCHAR(15))
BEGIN
	select functie from date_personale where date_personale.CNP = (select CNP from login where login.CNP=CNP);
END //

DELIMITER ;

DELIMITER //
CREATE PROCEDURE GetProfitMedicUnitate(IN CNP int,IN id_unit int)
BEGIN
	select a.salariu_neg + sum(s.pret*m.procent_servicii/100) from istoric_servicii i,angajat a,medic m,servicii s where i.CNP = CNP and i.id_unit = id_unit and i.id_serv = s.id_serv and m.CNP = CNP and a.CNP = CNP group by i.luna;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE GetProfitMedicSpecialitate(IN CNP int,IN id_spec int)
BEGIN
	select a.salariu_neg + sum(s.pret*m.procent_servicii/100) from istoric_servicii i,angajat a,medic m,servicii s where i.CNP = CNP and i.id_serv = s.id_serv and m.CNP = CNP and a.CNP = CNP and exists (select ss.id_spec from spec_serv ss where s.id_serv=ss.id_serv and ss.id_spec = id_spec) group by i.luna;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE GetProfitUnitatePerMedic(IN CNP int,IN id_unit int)
BEGIN
	declare sal int;
    select a.salariu_neg*ua.ore into sal from unit_ang ua,angajat a where ua.CNP = CNP and ua.id_unit=id_unit and a.CNP = CNP;
	select sum(s.pret-s.pret*m.procent_servicii/100)-sal from istoric_servicii i,servicii s,medic m where i.id_unit = id_unit and i.id_serv = s.id_serv and m.CNP=CNP  group by i.luna;
END //
DELIMITER ;


DELIMITER //
#select a.salariu_neg + sum(s.pret*m.procent_servicii/100) from istoric_servicii i,angajat a,medic m,servicii s where i.CNP = 1 and i.id_serv = s.id_serv and m.CNP = 1 and a.CNP = 1 and exists (select ss.id_spec from spec_serv ss where s.id_serv=ss.id_serv and ss.id_spec = 1) group by i.luna;
#call GetProfitUnitatePerMedic(1,1);
#call SearchAngajatProgram("Zoican","Denis","medic");
DELIMITER //
create procedure DeleteProgramS(in zi int,in start_p Time,in end_p Time,in id_unit int ,in CNP char(15))
BEGIN
	delete from program_ang_s  where program_ang_s.start_p = start_p and program_ang_s.end_p = end_p and program_ang_s.id_unit = id_unit and program_ang_s.CNP = CNP and program_ang_s.zi = zi;  
END//
DELIMITER //
create procedure deleteConcediu(in CNP char(15),in ziua Date)
begin
	delete from concediu  where concediu.CNP = CNP and concediu.ziua = ziua;
end //
DELIMITER //
create procedure InsertConcediu (in ziua Date,in CNP char(15))
begin
insert into concediu(ziua,CNP) values (ziua,CNP);
end //
DELIMITER //
create procedure InsertProgramS (in start_p Time,in end_p Time,in zi int,in CNP char(15),in id_unit int)
begin
insert into program_ang_s(start_p,end_p,zi,CNP,id_unit) values (start_p,end_p,zi,CNP,id_unit);
end //
DELIMITER //
create procedure UpdateProgramS (in start_p Time,in end_p Time,in zi int,in CNP char(15),in id_unit int,in newstart_p Time,in newend_p Time,in newid_unit int)
begin
UPDATE program_ang_s e
SET 
    start_p = newstart_p,
    end_p = newend_p,
    id_unit = newid_unit
WHERE
    e.start_p = start_p and  e.end_p = end_p and e.CNP = CNP and e.id_unit = id_unit and e.zi = zi;
end //

DELIMITER //
CREATE PROCEDURE GetProfitUnitate(IN id_unit int)
BEGIN
	select luna, sum(pret)-(select sum(m.procent_servicii*pret/100) from medic m where m.CNP=i.CNP)-(select  sum(a.salariu_neg*ua.ore) from unit_ang ua,angajat a where a.CNP = i.CNP and ua.CNP=i.CNP and ua.id_unit=i.id_unit) from istoric_servicii i,servicii s where id_unit=i.id_unit and i.id_serv=s.id_serv group by i.luna;
END //

call GetProfitUnitate(4);

DELIMITER //
 CREATE PROCEDURE SearchAngajatProgram(IN nume VARCHAR(30),IN prenume VARCHAR(30),IN functie VARCHAR(40))
BEGIN
	DECLARE CNP_search varchar(15);
    DECLARE tip_orar_search boolean;
	
    SELECT CNP INTO CNP_search from date_personale d where d.nume = nume and d.prenume = prenume and d.functie = functie; 
    SELECT tip_orar INTO tip_orar_search from angajat a where CNP = CNP_search;
    
    IF(tip_orar_search=0) then
	select zi,start_p,end_p,id_unit,(select denumire from unitate_medicala u where p.id_unit=u.id_unit) as nume_unitate   from program_ang_l p where p.CNP=CNP_search order by p.zi,p.start_p,p.end_p;
    else
	select zi,start_p,end_p,id_unit,(select denumire from unitate_medicala u where p.id_unit=u.id_unit) as nume_unitate  from program_ang_s p where p.CNP=CNP_search order by p.zi,p.start_p,p.end_p;
    end if;
END //

DELIMITER //
CREATE PROCEDURE SearchAngajatConcediu(IN nume VARCHAR(30),IN prenume VARCHAR(30),IN functie VARCHAR(40))
BEGIN
	DECLARE CNP_search varchar(15);
    DECLARE tip_orar_search boolean;
	
    SELECT CNP INTO CNP_search from date_personale d where d.nume = nume and d.prenume = prenume and d.functie = functie; 
    select ziua from concediu c where c.CNP = CNP_search order by ziua;
END //

DELIMITER //
create procedure UpdateConcediu (in ziua Date, CNP char(15),in newziua Date)
begin
UPDATE concediu e
SET 
    ziua = newziua
WHERE
    e.ziua = ziua and e.CNP = CNP;
end //


DELIMITER //
 CREATE PROCEDURE insertProgramare(IN CNP_medic VARCHAR(15),IN CNP_pacient VARCHAR(15),IN data date, IN start_p time,in end_p time,in durata int,in id_Unit varchar(30))
BEGIN
	insert into programare (data,start_p,end_p,CNP_medic,CNP_pacient,durata,id_Unit) VALUES (data,start_p,end_p,CNP_medic,CNP_pacient,durata,id_Unit);
END //

DELIMITER ;

DELIMITER //
 CREATE PROCEDURE InsertIstoricPacient(IN cnp_medic VARCHAR(15), IN cnp_pacient VARChar(30),IN simptome VARCHAR(30),IN diagnostic VARCHAR(30),IN recomandari VARCHAR(30))
BEGIN
	insert into istoric_pacient (cnp_medic,cnp_pacient,simptome,diagnostic,recomandari) VALUES(cnp_medic,cnp_pacient,simptome,diagnostic,recomandari);
END //

DELIMITER ;

DELIMITER //
 CREATE PROCEDURE creareRaport(rezultat int, cnp_pacient char(15))
BEGIN
	declare aux int;
    select id_istoric into aux from istoric_pacient where istoric_pacient.cnp_pacient=cnp_pacient;
	insert into raport_analize(rezultat,val_bin,id_istoric) values (rezultat,0,aux);
END //

DELIMITER ;


DELIMITER //
 CREATE PROCEDURE estePacient(IN cnp char(15))
BEGIN
	select nume from pacient where pacient.cnp=cnp;
END //

DELIMITER ;
