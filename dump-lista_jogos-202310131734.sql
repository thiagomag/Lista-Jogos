--
-- PostgreSQL database cluster dump
--

-- Started on 2023-10-13 17:34:56

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS;

--
-- User Configurations
--






--
-- Databases
--

--
-- Database "template1" dump
--

\connect template1

--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5 (Debian 14.5-1.pgdg110+1)
-- Dumped by pg_dump version 15.3

-- Started on 2023-10-13 17:34:56

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

-- *not* creating schema, since initdb creates it


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 3306 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE USAGE ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2023-10-13 17:34:56

--
-- PostgreSQL database dump complete
--

--
-- Database "lista_jogos" dump
--

--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5 (Debian 14.5-1.pgdg110+1)
-- Dumped by pg_dump version 15.3

-- Started on 2023-10-13 17:34:56

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3314 (class 1262 OID 16384)
-- Name: lista_jogos; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE lista_jogos WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';


ALTER DATABASE lista_jogos OWNER TO postgres;

\connect lista_jogos

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

-- *not* creating schema, since initdb creates it


ALTER SCHEMA public OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 210 (class 1259 OID 16400)
-- Name: lista_jogos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.lista_jogos (
    id integer NOT NULL,
    nome character varying(255) NOT NULL,
    estudio character varying(100) NOT NULL,
    plataforma character varying(50) NOT NULL,
    ano_lancamento integer NOT NULL,
    necessita_assinatura boolean NOT NULL,
    tipo character varying(20) NOT NULL,
    url_foto text,
    email_conta character varying(255),
    username character varying(100)
);


ALTER TABLE public.lista_jogos OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 16399)
-- Name: lista_jogos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.lista_jogos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.lista_jogos_id_seq OWNER TO postgres;

--
-- TOC entry 3316 (class 0 OID 0)
-- Dependencies: 209
-- Name: lista_jogos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.lista_jogos_id_seq OWNED BY public.lista_jogos.id;


--
-- TOC entry 3167 (class 2604 OID 16403)
-- Name: lista_jogos id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lista_jogos ALTER COLUMN id SET DEFAULT nextval('public.lista_jogos_id_seq'::regclass);


--
-- TOC entry 3308 (class 0 OID 16400)
-- Dependencies: 210
-- Data for Name: lista_jogos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.lista_jogos (id, nome, estudio, plataforma, ano_lancamento, necessita_assinatura, tipo, url_foto, email_conta, username) FROM stdin;
2	Anno 1701 - History Edition	Related Designs (Ubsoft Mainz)	ubisoft-connect	2006	f	digital	https://upload.wikimedia.org/wikipedia/en/9/97/Anno_1701.jpg?20080803100937	thiagomagdalena@gmail.com	thiagomag
3	Assassin's Creed	Ubisoft Montreal	ubisoft-connect	2007	f	digital	https://upload.wikimedia.org/wikipedia/en/5/52/Assassin%27s_Creed.jpg	thiagomagdalena@gmail.com	thiagomag
4	Assassin's Creed II	Ubisoft Montreal	ubisoft-connect	2009	f	digital	https://upload.wikimedia.org/wikipedia/en/7/77/Assassins_Creed_2_Box_Art.JPG	thiagomagdalena@gmail.com	thiagomag
5	Assassin's Creed: Brotherhood	Ubisoft Montreal	ubisoft-connect	2010	f	digital	https://upload.wikimedia.org/wikipedia/en/2/2a/Assassins_Creed_brotherhood_cover.jpg	thiagomagdalena@gmail.com	thiagomag
6	Assassin's Creed: Revelations	Ubisoft Montreal	ubisoft-connect	2011	f	digital	https://upload.wikimedia.org/wikipedia/en/thumb/d/d9/Assassins_Creed_Revelations_Cover.jpg/220px-Assassins_Creed_Revelations_Cover.jpg	thiagomagdalena@gmail.com	thiagomag
7	Assassin's Creed III	Ubisoft Montreal	ubisoft-connect	2012	f	digital	https://upload.wikimedia.org/wikipedia/en/thumb/2/29/Assassin%27s_Creed_III_Game_Cover.jpg/220px-Assassin%27s_Creed_III_Game_Cover.jpg	thiagomagdalena@gmail.com	thiagomag
8	Assassin's Creed III Remastered	Ubisoft Montreal	ubisoft-connect	2019	f	digital	https://cdn-products.eneba.com/resized-products/bwCl85_pqff8lk6VtTZJqkpATHxKm-FyfuW1zk3wPuc_350x200_1x-0.jpeg	thiagomagdalena@gmail.com	thiagomag
9	Assassin's Creed IV: Black Flag	Ubisoft Montreal	ubisoft-connect	2013	f	digital	https://upload.wikimedia.org/wikipedia/en/thumb/2/28/Assassin%27s_Creed_IV_-_Black_Flag_cover.jpg/220px-Assassin%27s_Creed_IV_-_Black_Flag_cover.jpg	thiagomagdalena@gmail.com	thiagomag
10	Assassin's Creed Freedom Cry	Ubisoft Quebec	ubisoft-connect	2013	f	digital	https://upload.wikimedia.org/wikipedia/en/thumb/3/3d/FreedomCry.png/220px-FreedomCry.png	thiagomagdalena@gmail.com	thiagomag
11	Assassin's Creed Unity	Ubisoft Montreal	ubisoft-connect	2014	f	digital	https://upload.wikimedia.org/wikipedia/en/thumb/4/41/Assassin%27s_Creed_Unity_cover.jpg/220px-Assassin%27s_Creed_Unity_cover.jpg	thiagomagdalena@gmail.com	thiagomag
12	Assassin's Creed Chronicles - China	Climax Studios	ubisoft-connect	2015	f	digital	https://image.api.playstation.com/cdn/JP0001/CUSA01406_00/qSCoFjrCrYyZvYToSaJOEGSfTXFyehUC.png	thiagomagdalena@gmail.com	thiagomag
13	Assassin's Creed Chronicles - India	Climax Studios	ubisoft-connect	2016	f	digital	https://cdn1.epicgames.com/offer/fc3ec7982b584a4291d7943204ea424b/ACCI_StorePortrait_1200x1600_1200x1600-658c1341bd20c00262f05d8f3f010c30	thiagomagdalena@gmail.com	thiagomag
14	Assassin's Creed Chronicles - Russia	Climax Studios	ubisoft-connect	2016	f	digital	https://howlongtobeat.com/games/33659_Assassins_Creed_Chronicles_Russia.jpg	thiagomagdalena@gmail.com	thiagomag
15	Assassin's Creed Syndicate	Ubisoft Quebec	ubisoft-connect	2015	f	digital	https://upload.wikimedia.org/wikipedia/en/thumb/f/f2/Assassin%27s_Creed_Syndicate_cover.jpg/220px-Assassin%27s_Creed_Syndicate_cover.jpg	thiagomagdalena@gmail.com	thiagomag
16	Assassin's Creed Origins	Ubisoft Montreal	ubisoft-connect	2017	f	digital	https://upload.wikimedia.org/wikipedia/en/thumb/4/4a/Assassin%27s_Creed_Origins_Cover_Art.png/220px-Assassin%27s_Creed_Origins_Cover_Art.png	thiagomagdalena@gmail.com	thiagomag
17	Assassin's Creed Valhalla	Ubisoft Montreal	ubisoft-connect	2020	f	digital	https://upload.wikimedia.org/wikipedia/en/thumb/f/ff/Assassin%27s_Creed_Valhalla_cover.jpg/220px-Assassin%27s_Creed_Valhalla_cover.jpg	thiagomagdalena@gmail.com	thiagomag
18	Discovery Tour: Ancient Greece	Ubisoft	ubisoft-connect	2019	f	digital	https://static.wikia.nocookie.net/assassinscreed/images/8/85/ACOD_Discovery_Tour_Promo_Image.jpg/revision/latest/scale-to-width-down/350?cb=20200203100337	thiagomagdalena@gmail.com	thiagomag
1	Assassin's Creed Odyssey	Ubsoft	ubisoft-connect	2018	f	digital	https://image.api.playstation.com/cdn/UP0001/CUSA09311_00/2XEenNH5pD4Ro375xwOG8tBwC9xMfEAE.png	thiagomagdalena@gmail.com	thiagomag
\.


--
-- TOC entry 3317 (class 0 OID 0)
-- Dependencies: 209
-- Name: lista_jogos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.lista_jogos_id_seq', 48, true);


--
-- TOC entry 3315 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE USAGE ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2023-10-13 17:34:56

--
-- PostgreSQL database dump complete
--

--
-- Database "postgres" dump
--

\connect postgres

--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5 (Debian 14.5-1.pgdg110+1)
-- Dumped by pg_dump version 15.3

-- Started on 2023-10-13 17:34:56

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

-- *not* creating schema, since initdb creates it


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 3306 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE USAGE ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2023-10-13 17:34:57

--
-- PostgreSQL database dump complete
--

-- Completed on 2023-10-13 17:34:57

--
-- PostgreSQL database cluster dump complete
--

