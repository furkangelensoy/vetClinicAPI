PGDMP                      |            vet    16.2    16.2 G    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    41295    vet    DATABASE     ~   CREATE DATABASE vet WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
    DROP DATABASE vet;
                postgres    false            �            1259    41781    animals    TABLE       CREATE TABLE public.animals (
    id bigint NOT NULL,
    birth_date date,
    breed character varying(255),
    color character varying(255),
    gender character varying(255),
    name character varying(255),
    species character varying(255),
    customer_id integer NOT NULL
);
    DROP TABLE public.animals;
       public         heap    postgres    false            �            1259    41780    animals_customer_id_seq    SEQUENCE     �   CREATE SEQUENCE public.animals_customer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.animals_customer_id_seq;
       public          postgres    false    217            �           0    0    animals_customer_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.animals_customer_id_seq OWNED BY public.animals.customer_id;
          public          postgres    false    216            �            1259    41779    animals_id_seq    SEQUENCE     w   CREATE SEQUENCE public.animals_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.animals_id_seq;
       public          postgres    false    217            �           0    0    animals_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.animals_id_seq OWNED BY public.animals.id;
          public          postgres    false    215            �            1259    41793    appointments    TABLE     �   CREATE TABLE public.appointments (
    id bigint NOT NULL,
    appointment_date timestamp(6) without time zone,
    animal_id integer NOT NULL,
    doctor_id integer NOT NULL
);
     DROP TABLE public.appointments;
       public         heap    postgres    false            �            1259    41791    appointments_animal_id_seq    SEQUENCE     �   CREATE SEQUENCE public.appointments_animal_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.appointments_animal_id_seq;
       public          postgres    false    221            �           0    0    appointments_animal_id_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.appointments_animal_id_seq OWNED BY public.appointments.animal_id;
          public          postgres    false    219            �            1259    41792    appointments_doctor_id_seq    SEQUENCE     �   CREATE SEQUENCE public.appointments_doctor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.appointments_doctor_id_seq;
       public          postgres    false    221            �           0    0    appointments_doctor_id_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.appointments_doctor_id_seq OWNED BY public.appointments.doctor_id;
          public          postgres    false    220            �            1259    41790    appointments_id_seq    SEQUENCE     |   CREATE SEQUENCE public.appointments_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.appointments_id_seq;
       public          postgres    false    221            �           0    0    appointments_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.appointments_id_seq OWNED BY public.appointments.id;
          public          postgres    false    218            �            1259    41803    available_dates    TABLE     y   CREATE TABLE public.available_dates (
    id bigint NOT NULL,
    available_date date,
    doctor_id integer NOT NULL
);
 #   DROP TABLE public.available_dates;
       public         heap    postgres    false            �            1259    41802    available_dates_doctor_id_seq    SEQUENCE     �   CREATE SEQUENCE public.available_dates_doctor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.available_dates_doctor_id_seq;
       public          postgres    false    224            �           0    0    available_dates_doctor_id_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.available_dates_doctor_id_seq OWNED BY public.available_dates.doctor_id;
          public          postgres    false    223            �            1259    41801    available_dates_id_seq    SEQUENCE        CREATE SEQUENCE public.available_dates_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.available_dates_id_seq;
       public          postgres    false    224                        0    0    available_dates_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.available_dates_id_seq OWNED BY public.available_dates.id;
          public          postgres    false    222            �            1259    41811 	   customers    TABLE     �   CREATE TABLE public.customers (
    id bigint NOT NULL,
    address character varying(255),
    city character varying(255),
    mail character varying(255),
    name character varying(255),
    phone character varying(255)
);
    DROP TABLE public.customers;
       public         heap    postgres    false            �            1259    41810    customers_id_seq    SEQUENCE     y   CREATE SEQUENCE public.customers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.customers_id_seq;
       public          postgres    false    226                       0    0    customers_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.customers_id_seq OWNED BY public.customers.id;
          public          postgres    false    225            �            1259    41820    doctors    TABLE     �   CREATE TABLE public.doctors (
    id bigint NOT NULL,
    address character varying(255),
    city character varying(255),
    mail character varying(255),
    name character varying(255),
    phone character varying(255)
);
    DROP TABLE public.doctors;
       public         heap    postgres    false            �            1259    41819    doctors_id_seq    SEQUENCE     w   CREATE SEQUENCE public.doctors_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.doctors_id_seq;
       public          postgres    false    228                       0    0    doctors_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.doctors_id_seq OWNED BY public.doctors.id;
          public          postgres    false    227            �            1259    41830    vaccines    TABLE     �   CREATE TABLE public.vaccines (
    id bigint NOT NULL,
    code character varying(255),
    name character varying(255),
    protection_finish_date date,
    protection_start_date date,
    animal_id integer NOT NULL
);
    DROP TABLE public.vaccines;
       public         heap    postgres    false            �            1259    41829    vaccines_animal_id_seq    SEQUENCE     �   CREATE SEQUENCE public.vaccines_animal_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.vaccines_animal_id_seq;
       public          postgres    false    231                       0    0    vaccines_animal_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.vaccines_animal_id_seq OWNED BY public.vaccines.animal_id;
          public          postgres    false    230            �            1259    41828    vaccines_id_seq    SEQUENCE     x   CREATE SEQUENCE public.vaccines_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.vaccines_id_seq;
       public          postgres    false    231                       0    0    vaccines_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.vaccines_id_seq OWNED BY public.vaccines.id;
          public          postgres    false    229            8           2604    41784 
   animals id    DEFAULT     h   ALTER TABLE ONLY public.animals ALTER COLUMN id SET DEFAULT nextval('public.animals_id_seq'::regclass);
 9   ALTER TABLE public.animals ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    215    217    217            9           2604    41785    animals customer_id    DEFAULT     z   ALTER TABLE ONLY public.animals ALTER COLUMN customer_id SET DEFAULT nextval('public.animals_customer_id_seq'::regclass);
 B   ALTER TABLE public.animals ALTER COLUMN customer_id DROP DEFAULT;
       public          postgres    false    216    217    217            :           2604    41796    appointments id    DEFAULT     r   ALTER TABLE ONLY public.appointments ALTER COLUMN id SET DEFAULT nextval('public.appointments_id_seq'::regclass);
 >   ALTER TABLE public.appointments ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    221    218    221            ;           2604    41797    appointments animal_id    DEFAULT     �   ALTER TABLE ONLY public.appointments ALTER COLUMN animal_id SET DEFAULT nextval('public.appointments_animal_id_seq'::regclass);
 E   ALTER TABLE public.appointments ALTER COLUMN animal_id DROP DEFAULT;
       public          postgres    false    221    219    221            <           2604    41798    appointments doctor_id    DEFAULT     �   ALTER TABLE ONLY public.appointments ALTER COLUMN doctor_id SET DEFAULT nextval('public.appointments_doctor_id_seq'::regclass);
 E   ALTER TABLE public.appointments ALTER COLUMN doctor_id DROP DEFAULT;
       public          postgres    false    221    220    221            =           2604    41806    available_dates id    DEFAULT     x   ALTER TABLE ONLY public.available_dates ALTER COLUMN id SET DEFAULT nextval('public.available_dates_id_seq'::regclass);
 A   ALTER TABLE public.available_dates ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    222    224    224            >           2604    41807    available_dates doctor_id    DEFAULT     �   ALTER TABLE ONLY public.available_dates ALTER COLUMN doctor_id SET DEFAULT nextval('public.available_dates_doctor_id_seq'::regclass);
 H   ALTER TABLE public.available_dates ALTER COLUMN doctor_id DROP DEFAULT;
       public          postgres    false    223    224    224            ?           2604    41814    customers id    DEFAULT     l   ALTER TABLE ONLY public.customers ALTER COLUMN id SET DEFAULT nextval('public.customers_id_seq'::regclass);
 ;   ALTER TABLE public.customers ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    225    226    226            @           2604    41823 
   doctors id    DEFAULT     h   ALTER TABLE ONLY public.doctors ALTER COLUMN id SET DEFAULT nextval('public.doctors_id_seq'::regclass);
 9   ALTER TABLE public.doctors ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    228    227    228            A           2604    41833    vaccines id    DEFAULT     j   ALTER TABLE ONLY public.vaccines ALTER COLUMN id SET DEFAULT nextval('public.vaccines_id_seq'::regclass);
 :   ALTER TABLE public.vaccines ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    229    231    231            B           2604    41834    vaccines animal_id    DEFAULT     x   ALTER TABLE ONLY public.vaccines ALTER COLUMN animal_id SET DEFAULT nextval('public.vaccines_animal_id_seq'::regclass);
 A   ALTER TABLE public.vaccines ALTER COLUMN animal_id DROP DEFAULT;
       public          postgres    false    231    230    231            �          0    41781    animals 
   TABLE DATA           c   COPY public.animals (id, birth_date, breed, color, gender, name, species, customer_id) FROM stdin;
    public          postgres    false    217   Q       �          0    41793    appointments 
   TABLE DATA           R   COPY public.appointments (id, appointment_date, animal_id, doctor_id) FROM stdin;
    public          postgres    false    221   bQ       �          0    41803    available_dates 
   TABLE DATA           H   COPY public.available_dates (id, available_date, doctor_id) FROM stdin;
    public          postgres    false    224   �Q       �          0    41811 	   customers 
   TABLE DATA           I   COPY public.customers (id, address, city, mail, name, phone) FROM stdin;
    public          postgres    false    226   �Q       �          0    41820    doctors 
   TABLE DATA           G   COPY public.doctors (id, address, city, mail, name, phone) FROM stdin;
    public          postgres    false    228   "R       �          0    41830    vaccines 
   TABLE DATA           l   COPY public.vaccines (id, code, name, protection_finish_date, protection_start_date, animal_id) FROM stdin;
    public          postgres    false    231   ]R                  0    0    animals_customer_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.animals_customer_id_seq', 1, false);
          public          postgres    false    216                       0    0    animals_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.animals_id_seq', 9, true);
          public          postgres    false    215                       0    0    appointments_animal_id_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.appointments_animal_id_seq', 1, false);
          public          postgres    false    219                       0    0    appointments_doctor_id_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.appointments_doctor_id_seq', 1, false);
          public          postgres    false    220            	           0    0    appointments_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.appointments_id_seq', 5, true);
          public          postgres    false    218            
           0    0    available_dates_doctor_id_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.available_dates_doctor_id_seq', 1, false);
          public          postgres    false    223                       0    0    available_dates_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.available_dates_id_seq', 3, true);
          public          postgres    false    222                       0    0    customers_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.customers_id_seq', 4, true);
          public          postgres    false    225                       0    0    doctors_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.doctors_id_seq', 4, true);
          public          postgres    false    227                       0    0    vaccines_animal_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.vaccines_animal_id_seq', 1, false);
          public          postgres    false    230                       0    0    vaccines_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.vaccines_id_seq', 9, true);
          public          postgres    false    229            D           2606    41789    animals animals_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.animals DROP CONSTRAINT animals_pkey;
       public            postgres    false    217            F           2606    41800    appointments appointments_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT appointments_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.appointments DROP CONSTRAINT appointments_pkey;
       public            postgres    false    221            H           2606    41809 $   available_dates available_dates_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.available_dates
    ADD CONSTRAINT available_dates_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.available_dates DROP CONSTRAINT available_dates_pkey;
       public            postgres    false    224            J           2606    41818    customers customers_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.customers DROP CONSTRAINT customers_pkey;
       public            postgres    false    226            L           2606    41827    doctors doctors_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.doctors
    ADD CONSTRAINT doctors_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.doctors DROP CONSTRAINT doctors_pkey;
       public            postgres    false    228            N           2606    41838    vaccines vaccines_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.vaccines
    ADD CONSTRAINT vaccines_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.vaccines DROP CONSTRAINT vaccines_pkey;
       public            postgres    false    231            P           2606    41844 (   appointments fk95vepu86o8syqtux9gkr71bhy    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT fk95vepu86o8syqtux9gkr71bhy FOREIGN KEY (animal_id) REFERENCES public.animals(id);
 R   ALTER TABLE ONLY public.appointments DROP CONSTRAINT fk95vepu86o8syqtux9gkr71bhy;
       public          postgres    false    4676    217    221            O           2606    41839 #   animals fkb36lt3kj4mrbdx5btxmp4j60n    FK CONSTRAINT     �   ALTER TABLE ONLY public.animals
    ADD CONSTRAINT fkb36lt3kj4mrbdx5btxmp4j60n FOREIGN KEY (customer_id) REFERENCES public.customers(id);
 M   ALTER TABLE ONLY public.animals DROP CONSTRAINT fkb36lt3kj4mrbdx5btxmp4j60n;
       public          postgres    false    217    226    4682            S           2606    41859 $   vaccines fkeasdy15b2kp5j4k13x2dfudqs    FK CONSTRAINT     �   ALTER TABLE ONLY public.vaccines
    ADD CONSTRAINT fkeasdy15b2kp5j4k13x2dfudqs FOREIGN KEY (animal_id) REFERENCES public.animals(id);
 N   ALTER TABLE ONLY public.vaccines DROP CONSTRAINT fkeasdy15b2kp5j4k13x2dfudqs;
       public          postgres    false    217    4676    231            Q           2606    41849 (   appointments fkmujeo4tymoo98cmf7uj3vsv76    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT fkmujeo4tymoo98cmf7uj3vsv76 FOREIGN KEY (doctor_id) REFERENCES public.doctors(id);
 R   ALTER TABLE ONLY public.appointments DROP CONSTRAINT fkmujeo4tymoo98cmf7uj3vsv76;
       public          postgres    false    228    221    4684            R           2606    41854 +   available_dates fknb419ilm71d71rm584rk460pk    FK CONSTRAINT     �   ALTER TABLE ONLY public.available_dates
    ADD CONSTRAINT fknb419ilm71d71rm584rk460pk FOREIGN KEY (doctor_id) REFERENCES public.doctors(id);
 U   ALTER TABLE ONLY public.available_dates DROP CONSTRAINT fknb419ilm71d71rm584rk460pk;
       public          postgres    false    228    4684    224            �   >   x�3��C����
m�e�"^YYiddbs��1�!c�e�"chh�,i�"�
�=... �A$�      �   @   x�3�4202�50�52S04�20�22�330�4�4�2��3LQ�YXXY����ec���� �h}      �   #   x�3�4202�50�52�4�2�r�@\�=... hE�      �   -   x�3��J �e�$;$�%��rVT��M�Pq#�D� Y9e      �   +   x�3���D�D���\β��
 ��.^�(�D� ��p      �   E   x�3�,.)��K�QFF&���Ff�LC.#����ԙr�2�b�Vu@IS(�H���ΒH���qqq ��0�     