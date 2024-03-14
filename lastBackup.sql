--
-- PostgreSQL database dump
--

-- Dumped from database version 16.0
-- Dumped by pg_dump version 16.0

-- Started on 2024-02-13 22:05:17

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
-- TOC entry 4830 (class 1262 OID 73889)
-- Name: martialartshalls; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE martialartshalls WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Sakha_Russia.1251';


ALTER DATABASE martialartshalls OWNER TO postgres;

\connect martialartshalls

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 223 (class 1259 OID 74018)
-- Name: coach; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.coach (
    id_coach integer NOT NULL,
    first_name text NOT NULL,
    last_name text NOT NULL,
    phone_number text,
    address text NOT NULL,
    education character varying(255) NOT NULL,
    additional_education character varying(255)
);


ALTER TABLE public.coach OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 74046)
-- Name: coach_id_coach_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.coach_id_coach_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.coach_id_coach_seq OWNER TO postgres;

--
-- TOC entry 4831 (class 0 OID 0)
-- Dependencies: 224
-- Name: coach_id_coach_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.coach_id_coach_seq OWNED BY public.coach.id_coach;


--
-- TOC entry 215 (class 1259 OID 73901)
-- Name: group_of_hall; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.group_of_hall (
    id_group integer NOT NULL,
    id_coach integer NOT NULL,
    id_training_room integer,
    id_section integer,
    id_gym integer,
    min_acceptable_age smallint NOT NULL,
    max_acceptable_age smallint NOT NULL,
    count_of_members smallint NOT NULL
);


ALTER TABLE public.group_of_hall OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 73904)
-- Name: group_of_hall_id_group_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.group_of_hall_id_group_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.group_of_hall_id_group_seq OWNER TO postgres;

--
-- TOC entry 4832 (class 0 OID 0)
-- Dependencies: 216
-- Name: group_of_hall_id_group_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.group_of_hall_id_group_seq OWNED BY public.group_of_hall.id_group;


--
-- TOC entry 217 (class 1259 OID 73905)
-- Name: gym; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.gym (
    id_gym integer NOT NULL,
    address character varying(200) NOT NULL
);


ALTER TABLE public.gym OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 73908)
-- Name: gym_id_gym_seq1; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.gym ALTER COLUMN id_gym ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.gym_id_gym_seq1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 219 (class 1259 OID 73929)
-- Name: section_of_martial_art; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.section_of_martial_art (
    id_section integer NOT NULL,
    section_name character varying(200) NOT NULL
);


ALTER TABLE public.section_of_martial_art OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 73932)
-- Name: section_of_martial_art_id_section_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.section_of_martial_art_id_section_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.section_of_martial_art_id_section_seq OWNER TO postgres;

--
-- TOC entry 4833 (class 0 OID 0)
-- Dependencies: 220
-- Name: section_of_martial_art_id_section_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.section_of_martial_art_id_section_seq OWNED BY public.section_of_martial_art.id_section;


--
-- TOC entry 221 (class 1259 OID 73933)
-- Name: training_room; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.training_room (
    id_training_room integer NOT NULL,
    room_number integer NOT NULL
);


ALTER TABLE public.training_room OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 73936)
-- Name: training_room_id_training_room_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.training_room_id_training_room_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.training_room_id_training_room_seq OWNER TO postgres;

--
-- TOC entry 4834 (class 0 OID 0)
-- Dependencies: 222
-- Name: training_room_id_training_room_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.training_room_id_training_room_seq OWNED BY public.training_room.id_training_room;


--
-- TOC entry 4657 (class 2604 OID 74047)
-- Name: coach id_coach; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.coach ALTER COLUMN id_coach SET DEFAULT nextval('public.coach_id_coach_seq'::regclass);


--
-- TOC entry 4654 (class 2604 OID 73942)
-- Name: group_of_hall id_group; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.group_of_hall ALTER COLUMN id_group SET DEFAULT nextval('public.group_of_hall_id_group_seq'::regclass);


--
-- TOC entry 4655 (class 2604 OID 73945)
-- Name: section_of_martial_art id_section; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.section_of_martial_art ALTER COLUMN id_section SET DEFAULT nextval('public.section_of_martial_art_id_section_seq'::regclass);


--
-- TOC entry 4656 (class 2604 OID 73946)
-- Name: training_room id_training_room; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.training_room ALTER COLUMN id_training_room SET DEFAULT nextval('public.training_room_id_training_room_seq'::regclass);


--
-- TOC entry 4823 (class 0 OID 74018)
-- Dependencies: 223
-- Data for Name: coach; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.coach VALUES (1, 'Alexey', 'Georgiyevich', '+78238882343', 'Bredovaya 23', 'M.V. Lomonosov Moscow State University', NULL) ON CONFLICT DO NOTHING;
INSERT INTO public.coach VALUES (2, 'Viktor', 'Martynovich', '+76253678232', 'Mayakovskaya 40', 'Moscow Pedagogical State University', NULL) ON CONFLICT DO NOTHING;
INSERT INTO public.coach VALUES (3, 'Oleg', 'Alexeevich', '+79993334543', 'Bredovaya 26', 'MIREA', NULL) ON CONFLICT DO NOTHING;
INSERT INTO public.coach VALUES (4, 'Dmitriy', 'Viktorovich', '+79112763512', 'Letnaya 42', 'Moscow Pedagogical State University', NULL) ON CONFLICT DO NOTHING;
INSERT INTO public.coach VALUES (5, 'Vasiliy', 'Artemovich', '+79033030880', 'Mayakovskaya 45', 'Moscow Pedagogical State University', NULL) ON CONFLICT DO NOTHING;


--
-- TOC entry 4815 (class 0 OID 73901)
-- Dependencies: 215
-- Data for Name: group_of_hall; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.group_of_hall VALUES (1, 2, 1, 1, 1, 16, 55, 13) ON CONFLICT DO NOTHING;
INSERT INTO public.group_of_hall VALUES (2, 5, 1, 2, 1, 8, 16, 14) ON CONFLICT DO NOTHING;
INSERT INTO public.group_of_hall VALUES (3, 3, 2, 1, 2, 8, 16, 20) ON CONFLICT DO NOTHING;
INSERT INTO public.group_of_hall VALUES (4, 4, 3, 3, 2, 16, 55, 9) ON CONFLICT DO NOTHING;
INSERT INTO public.group_of_hall VALUES (5, 1, 4, 3, 2, 16, 55, 10) ON CONFLICT DO NOTHING;
INSERT INTO public.group_of_hall VALUES (7, 2, 1, 2, 2, 16, 34, 21) ON CONFLICT DO NOTHING;
INSERT INTO public.group_of_hall VALUES (8, 2, 1, 2, 1, 2, 12, 11) ON CONFLICT DO NOTHING;


--
-- TOC entry 4817 (class 0 OID 73905)
-- Dependencies: 217
-- Data for Name: gym; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (1, 'Mayakovskaya 11') ON CONFLICT DO NOTHING;
INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (2, 'Letnaya 3') ON CONFLICT DO NOTHING;
INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (3, 'New gym,') ON CONFLICT DO NOTHING;
INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (6, ',wwwwwwwwwww') ON CONFLICT DO NOTHING;
INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (8, 'new 3,') ON CONFLICT DO NOTHING;
INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (4, '') ON CONFLICT DO NOTHING;
INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (9, 'new 4') ON CONFLICT DO NOTHING;
INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (5, ',qeqweqe') ON CONFLICT DO NOTHING;
INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (10, 'ffffff,') ON CONFLICT DO NOTHING;
INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (13, 'adadadgssssss,') ON CONFLICT DO NOTHING;
INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (14, 'qweqeqe,') ON CONFLICT DO NOTHING;
INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (15, 'dadwdqweqeq,') ON CONFLICT DO NOTHING;
INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (16, 'awegsg,') ON CONFLICT DO NOTHING;
INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (17, 'adawd,') ON CONFLICT DO NOTHING;
INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (18, 'wawwwwwwww') ON CONFLICT DO NOTHING;
INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (19, 'eeeeeeeeeeeee') ON CONFLICT DO NOTHING;
INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (25, 'enwwewe') ON CONFLICT DO NOTHING;
INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (26, 'New row') ON CONFLICT DO NOTHING;
INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (20, ',Edited333') ON CONFLICT DO NOTHING;
INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (21, 'www') ON CONFLICT DO NOTHING;
INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (27, 'new good gy') ON CONFLICT DO NOTHING;
INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (28, 'not rr') ON CONFLICT DO NOTHING;
INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (29, 'reee') ON CONFLICT DO NOTHING;
INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (30, 'fef') ON CONFLICT DO NOTHING;
INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (31, 'fsdfs') ON CONFLICT DO NOTHING;
INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (32, 'wdaw') ON CONFLICT DO NOTHING;
INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (33, 'wada') ON CONFLICT DO NOTHING;
INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (34, 'dawdad') ON CONFLICT DO NOTHING;
INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (35, '22') ON CONFLICT DO NOTHING;
INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (7, 'www') ON CONFLICT DO NOTHING;
INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (36, 'eeee') ON CONFLICT DO NOTHING;
INSERT INTO public.gym OVERRIDING SYSTEM VALUE VALUES (38, 'уку23') ON CONFLICT DO NOTHING;


--
-- TOC entry 4819 (class 0 OID 73929)
-- Dependencies: 219
-- Data for Name: section_of_martial_art; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.section_of_martial_art VALUES (1, 'Muay Thai') ON CONFLICT DO NOTHING;
INSERT INTO public.section_of_martial_art VALUES (2, 'Boxing') ON CONFLICT DO NOTHING;
INSERT INTO public.section_of_martial_art VALUES (3, 'Sambo') ON CONFLICT DO NOTHING;


--
-- TOC entry 4821 (class 0 OID 73933)
-- Dependencies: 221
-- Data for Name: training_room; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.training_room VALUES (1, 121) ON CONFLICT DO NOTHING;
INSERT INTO public.training_room VALUES (2, 311) ON CONFLICT DO NOTHING;
INSERT INTO public.training_room VALUES (4, 111) ON CONFLICT DO NOTHING;
INSERT INTO public.training_room VALUES (6, 919) ON CONFLICT DO NOTHING;
INSERT INTO public.training_room VALUES (3, 232) ON CONFLICT DO NOTHING;
INSERT INTO public.training_room VALUES (8, 22222) ON CONFLICT DO NOTHING;
INSERT INTO public.training_room VALUES (9, 22222) ON CONFLICT DO NOTHING;
INSERT INTO public.training_room VALUES (10, 11) ON CONFLICT DO NOTHING;


--
-- TOC entry 4835 (class 0 OID 0)
-- Dependencies: 224
-- Name: coach_id_coach_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.coach_id_coach_seq', 6, true);


--
-- TOC entry 4836 (class 0 OID 0)
-- Dependencies: 216
-- Name: group_of_hall_id_group_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.group_of_hall_id_group_seq', 9, true);


--
-- TOC entry 4837 (class 0 OID 0)
-- Dependencies: 218
-- Name: gym_id_gym_seq1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.gym_id_gym_seq1', 38, true);


--
-- TOC entry 4838 (class 0 OID 0)
-- Dependencies: 220
-- Name: section_of_martial_art_id_section_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.section_of_martial_art_id_section_seq', 4, false);


--
-- TOC entry 4839 (class 0 OID 0)
-- Dependencies: 222
-- Name: training_room_id_training_room_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.training_room_id_training_room_seq', 10, true);


--
-- TOC entry 4667 (class 2606 OID 74032)
-- Name: coach coach_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.coach
    ADD CONSTRAINT coach_pkey PRIMARY KEY (id_coach);


--
-- TOC entry 4659 (class 2606 OID 73951)
-- Name: group_of_hall group_of_hall_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.group_of_hall
    ADD CONSTRAINT group_of_hall_pkey PRIMARY KEY (id_group);


--
-- TOC entry 4661 (class 2606 OID 73953)
-- Name: gym gym_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gym
    ADD CONSTRAINT gym_pkey PRIMARY KEY (id_gym);


--
-- TOC entry 4663 (class 2606 OID 73961)
-- Name: section_of_martial_art section_of_martial_art_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.section_of_martial_art
    ADD CONSTRAINT section_of_martial_art_pkey PRIMARY KEY (id_section);


--
-- TOC entry 4665 (class 2606 OID 73965)
-- Name: training_room training_room_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.training_room
    ADD CONSTRAINT training_room_pkey PRIMARY KEY (id_training_room);


--
-- TOC entry 4668 (class 2606 OID 82086)
-- Name: group_of_hall group_of_hall_id_coach_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.group_of_hall
    ADD CONSTRAINT group_of_hall_id_coach_fkey FOREIGN KEY (id_coach) REFERENCES public.coach(id_coach);


--
-- TOC entry 4669 (class 2606 OID 82091)
-- Name: group_of_hall group_of_hall_id_gym_frey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.group_of_hall
    ADD CONSTRAINT group_of_hall_id_gym_frey FOREIGN KEY (id_gym) REFERENCES public.gym(id_gym);


--
-- TOC entry 4670 (class 2606 OID 73971)
-- Name: group_of_hall group_of_hall_id_section_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.group_of_hall
    ADD CONSTRAINT group_of_hall_id_section_fkey FOREIGN KEY (id_section) REFERENCES public.section_of_martial_art(id_section);


--
-- TOC entry 4671 (class 2606 OID 73976)
-- Name: group_of_hall group_of_hall_id_training_room_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.group_of_hall
    ADD CONSTRAINT group_of_hall_id_training_room_fkey FOREIGN KEY (id_training_room) REFERENCES public.training_room(id_training_room);


-- Completed on 2024-02-13 22:05:18

--
-- PostgreSQL database dump complete
--

