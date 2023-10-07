CREATE TABLE lista_jogos (
    id serial not null,
    nome varchar(255) not null,
    estudio varchar(100) not null,
    plataforma varchar(50) not null,
    ano_lancamento integer not null,
    necessita_assinatura bool not null,
    tipo varchar(20) not null,
    url_foto text null,
    email_conta varchar(100) null,
    username varchar(100) null
);

DROP TABLE lista_jogos;