--postgres - es el usuario creado al instalar postgres
GRANT USAGE ON SCHEMA corporative TO postgres;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA corporative TO postgres;
GRANT USAGE ON ALL SEQUENCES IN SCHEMA corporative TO postgres;