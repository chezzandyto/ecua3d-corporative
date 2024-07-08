-- nombre base de tablas
-- (corp)   (t)
-- corporative table


-- Quality
CREATE TABLE corporative.corpt_quality (
	quality_id BIGINT DEFAULT nextval('corporative.corps_quality'),
	name VARCHAR(64) NOT NULL,
	
	status VARCHAR(1) NOT NULL DEFAULT 1,
	created_by_user VARCHAR(36) NOT NULL,
	created_date TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
	last_modified_by_user VARCHAR(36),
	last_modified_date TIMESTAMP WITH TIME ZONE,
	created_from_ip VARCHAR(64) NOT NULL DEFAULT '127.0.0.1',
	updated_from_ip VARCHAR(64),
	CONSTRAINT corppr_pk_qlt PRIMARY KEY (quality_id)
);

COMMENT ON TABLE corporative.corpt_quality IS 'Quality Table';
COMMENT ON COLUMN corporative.corpt_quality.quality_id IS 'Quality id';
COMMENT ON COLUMN corporative.corpt_quality.name IS 'Quality Name';

COMMENT ON COLUMN corporative.corpt_quality.status IS 'Record status';
COMMENT ON COLUMN corporative.corpt_quality.created_by_user IS 'Id of the user who created the record';
COMMENT ON COLUMN corporative.corpt_quality.created_date IS 'Record creation date';
COMMENT ON COLUMN corporative.corpt_quality.last_modified_by_user IS 'Id of the user who made the last modification';
COMMENT ON COLUMN corporative.corpt_quality.last_modified_date IS 'Date of the last modification of the record';
COMMENT ON COLUMN corporative.corpt_quality.created_from_ip IS 'IP address of the computer from where the record was created';
COMMENT ON COLUMN corporative.corpt_quality.updated_from_ip IS 'IP address of the equipment from where the last change was made';
COMMENT ON CONSTRAINT corppr_pk_qlt ON corporative.corpt_quality  IS 'Restriction PK Quality';

-- Material
CREATE TABLE corporative.corpt_material (
	material_id BIGINT DEFAULT nextval('corporative.corps_material'),
	name VARCHAR(64) NOT NULL,
	
	status VARCHAR(1) NOT NULL DEFAULT 1,
	created_by_user VARCHAR(36) NOT NULL,
	created_date TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
	last_modified_by_user VARCHAR(36),
	last_modified_date TIMESTAMP WITH TIME ZONE,
	created_from_ip VARCHAR(64) NOT NULL DEFAULT '127.0.0.1',
	updated_from_ip VARCHAR(64),
	CONSTRAINT corppr_pk_mtr PRIMARY KEY (material_id)
);

COMMENT ON TABLE corporative.corpt_material IS 'material Table';
COMMENT ON COLUMN corporative.corpt_material.material_id IS 'material id';
COMMENT ON COLUMN corporative.corpt_material.name IS 'material Name';

COMMENT ON COLUMN corporative.corpt_material.status IS 'Record status';
COMMENT ON COLUMN corporative.corpt_material.created_by_user IS 'Id of the user who created the record';
COMMENT ON COLUMN corporative.corpt_material.created_date IS 'Record creation date';
COMMENT ON COLUMN corporative.corpt_material.last_modified_by_user IS 'Id of the user who made the last modification';
COMMENT ON COLUMN corporative.corpt_material.last_modified_date IS 'Date of the last modification of the record';
COMMENT ON COLUMN corporative.corpt_material.created_from_ip IS 'IP address of the computer from where the record was created';
COMMENT ON COLUMN corporative.corpt_material.updated_from_ip IS 'IP address of the equipment from where the last change was made';
COMMENT ON CONSTRAINT corppr_pk_mtr ON corporative.corpt_material  IS 'Restriction PK Material';

-- Color
CREATE TABLE corporative.corpt_color (
	color_id BIGINT DEFAULT nextval('corporative.corps_color'),
	name VARCHAR(64) NOT NULL,
	hexadecimal VARCHAR(64) NULL,
	
	status VARCHAR(1) NOT NULL DEFAULT 1,
	created_by_user VARCHAR(36) NOT NULL,
	created_date TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
	last_modified_by_user VARCHAR(36),
	last_modified_date TIMESTAMP WITH TIME ZONE,
	created_from_ip VARCHAR(64) NOT NULL DEFAULT '127.0.0.1',
	updated_from_ip VARCHAR(64),
	CONSTRAINT corppr_pk_clr PRIMARY KEY (color_id)
);

COMMENT ON TABLE corporative.corpt_color IS 'color Table';
COMMENT ON COLUMN corporative.corpt_color.color_id IS 'color id';
COMMENT ON COLUMN corporative.corpt_color.name IS 'color Name';
COMMENT ON COLUMN corporative.corpt_color.hexadecimal IS 'color in hexadecimal';

COMMENT ON COLUMN corporative.corpt_color.status IS 'Record status';
COMMENT ON COLUMN corporative.corpt_color.created_by_user IS 'Id of the user who created the record';
COMMENT ON COLUMN corporative.corpt_color.created_date IS 'Record creation date';
COMMENT ON COLUMN corporative.corpt_color.last_modified_by_user IS 'Id of the user who made the last modification';
COMMENT ON COLUMN corporative.corpt_color.last_modified_date IS 'Date of the last modification of the record';
COMMENT ON COLUMN corporative.corpt_color.created_from_ip IS 'IP address of the computer from where the record was created';
COMMENT ON COLUMN corporative.corpt_color.updated_from_ip IS 'IP address of the equipment from where the last change was made';
COMMENT ON CONSTRAINT corppr_pk_clr ON corporative.corpt_color  IS 'Restriction PK Color';



-- Filament
CREATE TABLE corporative.corpt_filament (
	filament_id BIGINT DEFAULT nextval('corporative.corps_filament'),
	material_id BIGINT NOT NULL,
	color_id BIGINT NOT NULL,
	brand VARCHAR(64) NOT NULL,
	weight INT NOT NULL, 
	diameter DECIMAL(8,2), 
	temperature DECIMAL(8,2),
	cost MONEY,
	vendor_id VARCHAR(64) NULL,
	remaining INT NULL, 
	
	status VARCHAR(1) NOT NULL DEFAULT 1,
	created_by_user VARCHAR(36) NOT NULL,
	created_date TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
	last_modified_by_user VARCHAR(36),
	last_modified_date TIMESTAMP WITH TIME ZONE,
	created_from_ip VARCHAR(64) NOT NULL DEFAULT '127.0.0.1',
	updated_from_ip VARCHAR(64),
	CONSTRAINT corppr_pk_flm PRIMARY KEY (filament_id)
);

COMMENT ON TABLE corporative.corpt_filament IS 'filament Table';
COMMENT ON COLUMN corporative.corpt_filament.filament_id IS 'filament id';
COMMENT ON COLUMN corporative.corpt_filament.color_id IS 'FK relation with color table';
COMMENT ON COLUMN corporative.corpt_filament.material_id IS 'FK relation with material table';
COMMENT ON COLUMN corporative.corpt_filament.brand IS 'Is brand of filament';
COMMENT ON COLUMN corporative.corpt_filament.weight IS 'Is weight of filament in g';
COMMENT ON COLUMN corporative.corpt_filament.diameter IS 'Is diameter of filament in mm';
COMMENT ON COLUMN corporative.corpt_filament.temperature IS 'Is temperature of filament in °C';
COMMENT ON COLUMN corporative.corpt_filament.cost IS 'Is cost of filament in $';
COMMENT ON COLUMN corporative.corpt_filament.vendor_id IS 'Is id of construction vendor';
COMMENT ON COLUMN corporative.corpt_filament.remaining IS 'Is the remaining weight';



COMMENT ON COLUMN corporative.corpt_filament.status IS 'Record status';
COMMENT ON COLUMN corporative.corpt_filament.created_by_user IS 'Id of the user who created the record';
COMMENT ON COLUMN corporative.corpt_filament.created_date IS 'Record creation date';
COMMENT ON COLUMN corporative.corpt_filament.last_modified_by_user IS 'Id of the user who made the last modification';
COMMENT ON COLUMN corporative.corpt_filament.last_modified_date IS 'Date of the last modification of the record';
COMMENT ON COLUMN corporative.corpt_filament.created_from_ip IS 'IP address of the computer from where the record was created';
COMMENT ON COLUMN corporative.corpt_filament.updated_from_ip IS 'IP address of the equipment from where the last change was made';
COMMENT ON CONSTRAINT corppr_pk_flm ON corporative.corpt_filament  IS 'Restriction PK filament';

