create table medicos
(

    id           bigint       NOT NULL auto_increment,
    nombre       VARCHAR(100) NOT NULL,
    email        VARCHAR(100) NOT NULL,
    documento    VARCHAR(100) NOT NULL ,
    especialidad VARCHAR(100) NOT NULL ,
    calle        VARCHAR(100) NOT NULL ,
    distrito     VARCHAR(100) NOT NULL ,
    ciudad       VARCHAR(100) NOT NULL ,
    numero       VARCHAR(20),
    complemento  VARCHAR(100),


    primary key (id)

);


