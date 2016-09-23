--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.4
-- Dumped by pg_dump version 9.5.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: clients; Type: TABLE; Schema: public; Owner: alanamorosky
--

CREATE TABLE clients (
    id integer NOT NULL,
    name character varying,
    stylist_id integer,
    phone_number character varying
);


ALTER TABLE clients OWNER TO alanamorosky;

--
-- Name: clients_id_seq; Type: SEQUENCE; Schema: public; Owner: alanamorosky
--

CREATE SEQUENCE clients_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE clients_id_seq OWNER TO alanamorosky;

--
-- Name: clients_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: alanamorosky
--

ALTER SEQUENCE clients_id_seq OWNED BY clients.id;


--
-- Name: stylists; Type: TABLE; Schema: public; Owner: alanamorosky
--

CREATE TABLE stylists (
    id integer NOT NULL,
    name character varying,
    specialty character varying,
    extention integer,
    bio character varying,
    image_src character varying
);


ALTER TABLE stylists OWNER TO alanamorosky;

--
-- Name: stylists_id_seq; Type: SEQUENCE; Schema: public; Owner: alanamorosky
--

CREATE SEQUENCE stylists_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE stylists_id_seq OWNER TO alanamorosky;

--
-- Name: stylists_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: alanamorosky
--

ALTER SEQUENCE stylists_id_seq OWNED BY stylists.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: alanamorosky
--

ALTER TABLE ONLY clients ALTER COLUMN id SET DEFAULT nextval('clients_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: alanamorosky
--

ALTER TABLE ONLY stylists ALTER COLUMN id SET DEFAULT nextval('stylists_id_seq'::regclass);


--
-- Data for Name: clients; Type: TABLE DATA; Schema: public; Owner: alanamorosky
--

COPY clients (id, name, stylist_id, phone_number) FROM stdin;
3	bill	2	12
5	Client 1	2	12934801297834
4	bill	2	56
\.


--
-- Name: clients_id_seq; Type: SEQUENCE SET; Schema: public; Owner: alanamorosky
--

SELECT pg_catalog.setval('clients_id_seq', 5, true);


--
-- Data for Name: stylists; Type: TABLE DATA; Schema: public; Owner: alanamorosky
--

COPY stylists (id, name, specialty, extention, bio, image_src) FROM stdin;
1	Hank	Propane	2	Sells propane and propane accessories	Hank.jpg
2	Marge Simpson	Tall Hair	2	Tv actress	images/marge.gif
\.


--
-- Name: stylists_id_seq; Type: SEQUENCE SET; Schema: public; Owner: alanamorosky
--

SELECT pg_catalog.setval('stylists_id_seq', 2, true);


--
-- Name: clients_pkey; Type: CONSTRAINT; Schema: public; Owner: alanamorosky
--

ALTER TABLE ONLY clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (id);


--
-- Name: stylists_pkey; Type: CONSTRAINT; Schema: public; Owner: alanamorosky
--

ALTER TABLE ONLY stylists
    ADD CONSTRAINT stylists_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: alanamorosky
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM alanamorosky;
GRANT ALL ON SCHEMA public TO alanamorosky;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

