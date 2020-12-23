---line name---
select ln.name as line_name from line_no as ln inner join j_process_line_no as jln on ln.idline_no = jln.line_no inner join process as p on p.idprocess = jln.process where p.name = 'Process_1';

--machine_name---
select mn.name as machine_name from machine_name as mn inner join j_process_line_no_machine_name as jlm on mn.idmachine_name = jlm.machine_name inner join process as p on p.idprocess = jlm.process inner join line_no as ln on ln.idline_no = jlm.line_no where p.name = 'Process_2' and ln.name = 'line_no_1';

---machine_drawing--
select md.name as machine_drawing from machine_drawing as md inner join j_process_line_no_machine_name_drawing as jlm on md.idmachine_drawing = jlm.machine_drawing inner join process as p on p.idprocess = jlm.process inner join line_no as ln on ln.idline_no = jlm.line_no inner join machine_name as mn on mn.idmachine_name = jlm.machine_name where p.name = 'Process_1' and ln.name = 'line_no_1' and mn.name ='machine_name_01';

---sub folder--
select sf.name as sub_folder_name from sub_folder as sf inner join j_process_line_no_machine_name_drawing_sub_folder as jlm on sf.idsub_folder = jlm.sub_folder inner join process as p on p.idprocess = jlm.process inner join line_no as ln on ln.idline_no = jlm.line_no inner join machine_name as mn on mn.idmachine_name = jlm.machine_name inner join machine_drawing as md on md.idmachine_drawing = jlm.machine_drawing where p.name = 'Process_1' and ln.name = 'line_no_1' and mn.name ='machine_name_01' and md.name='machine_drawing_01';
