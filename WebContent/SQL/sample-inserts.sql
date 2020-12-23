--process--
INSERT INTO wcommon.process (idprocess, name)
VALUES ('idprocess_01', 'Process_1'),
('idprocess_02','Process_2'),
('idprocess_03','Process_3');

--line_no--
INSERT INTO wcommon.line_no (idline_no, name)
VALUES ('idline_no_01', 'line_no_1'),
('idline_no_02','line_no_2'),
('idline_no_03','line_no_3');

--machine_name--
INSERT INTO wcommon.machine_name (idmachine_name, name)
VALUES ('idmachine_name_01', 'machine_name_01'),
('idmachine_name_02','machine_name_02'),
('idmachine_name_03','machine_name_03');

--machine_drawing--
INSERT INTO wcommon.machine_drawing (idmachine_drawing, name)
VALUES ('idmachine_drawing_01', 'machine_drawing_01'),
('idmachine_drawing_02','machine_drawing_02'),
('idmachine_drawing_03','machine_drawing_03');

--sub_folder--
INSERT INTO wcommon.sub_folder (idsub_folder, name)
VALUES ('idsub_folder_01', 'sub_folder_01'),
('idsub_folder_02','sub_folder_02'),
('idsub_folder_03','sub_folder_03');

---j_process_line_no--
INSERT INTO wcommon.j_process_line_no (idj_process_line_no, process,line_no)
VALUES ('idline_no_01','idprocess_01','idline_no_01'),
('idline_no_02','idprocess_01','idline_no_02'),
('idline_no_03','idprocess_02','idline_no_01'),
('idline_no_04','idprocess_02','idline_no_02');

--j_process_line_no_machine_name--
INSERT INTO wcommon.j_process_line_no_machine_name (idj_process_line_no_machine_name, process,line_no,machine_name)
VALUES ('idj_process_line_no_machine_name_01','idprocess_01','idline_no_01','idmachine_name_01'),
('idj_process_line_no_machine_name_02','idprocess_01','idline_no_01','idmachine_name_02'),
('idj_process_line_no_machine_name_03','idprocess_02','idline_no_01','idmachine_name_01'),
('idj_process_line_no_machine_name_04','idprocess_02','idline_no_01','idmachine_name_02');

---j_process_line_no_machine_name_drawing--
INSERT INTO wcommon.j_process_line_no_machine_name_drawing (idj_process_line_no_machine_name_drawing, process,line_no,machine_name,machine_drawing)
VALUES ('idj_process_line_no_machine_name_drawing_01','idprocess_01','idline_no_01','idmachine_name_01','idmachine_drawing_01'),
('idj_process_line_no_machine_name_drawing_02','idprocess_01','idline_no_01','idmachine_name_01','idmachine_drawing_02'),
('idj_process_line_no_machine_name_drawing_03','idprocess_01','idline_no_01','idmachine_name_02','idmachine_drawing_01'),
('idj_process_line_no_machine_name_drawing_04','idprocess_01','idline_no_01','idmachine_name_02','idmachine_drawing_02'),
('idj_process_line_no_machine_name_drawing_05','idprocess_02','idline_no_01','idmachine_name_01','idmachine_drawing_01'),
('idj_process_line_no_machine_name_drawing_06','idprocess_02','idline_no_01','idmachine_name_02','idmachine_drawing_02');

--j_process_line_no_machine_name_drawing_sub_folder--
INSERT INTO wcommon.j_process_line_no_machine_name_drawing_sub_folder (idj_process_line_no_machine_name_drawing_sub_folder, process,line_no,machine_name,machine_drawing,sub_folder)
VALUES ('idj_process_line_no_machine_name_01','idprocess_01','idline_no_01','idmachine_name_01','idmachine_drawing_01','idsub_folder_01'),
('idj_process_line_no_machine_name_02','idprocess_01','idline_no_01','idmachine_name_01','idmachine_drawing_01','idsub_folder_02'),
('idj_process_line_no_machine_name_03','idprocess_01','idline_no_01','idmachine_name_02','idmachine_drawing_01','idsub_folder_03'),
('idj_process_line_no_machine_name_04','idprocess_01','idline_no_01','idmachine_name_02','idmachine_drawing_02','idsub_folder_01'),
('idj_process_line_no_machine_name_05','idprocess_02','idline_no_01','idmachine_name_01','idmachine_drawing_01','idsub_folder_02'),
('idj_process_line_no_machine_name_06','idprocess_02','idline_no_01','idmachine_name_02','idmachine_drawing_02','idsub_folder_01');