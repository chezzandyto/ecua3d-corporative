INSERT INTO corporative.corpt_filament (color_id, material_id, brand, weight, diameter, temperature, cost, vendor_id, status, created_by_user) 
VALUES ((select c.color_id  from corporative.corpt_color c where c."name" like '%Naranja%'), (select m.material_id  from corporative.corpt_material m where m."name" like '%PETG%'), 'Prusa', 1051, 1.75, 240, '$47.50' , 'd0a23d96c1', '1', null);
INSERT INTO corporative.corpt_filament (color_id, material_id, brand, weight, diameter, temperature, cost, status, created_by_user) 
VALUES ((select c.color_id  from corporative.corpt_color c where c."name" like '%Azul%'), (select m.material_id  from corporative.corpt_material m where m."name" like '%PLA%'), 'Smartfil', 750, 1.75, 215, '$24', '1', null);

