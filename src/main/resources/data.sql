--  INSERT INTO Roles (  rolename,Is_delete )
--  VALUES
--  ('ROLE_ADMIN',0),
--  ('ROLE_ORGANIZER',0),
--  ('ROLE_USER',0);
--
--
--  INSERT INTO Users ( First_name, Last_name,username,password,Email,Mobile_number,Gender,Address,Is_delete,rolename,enabled)
--  VALUES
--
--  ('malk','aljamman','ali66','$2a$10$tYC0.tcXH1xDtqCGR9JC6edQeBTWhXPMQqonF4iM34zFecgxSa23a','ali200766@hotmail.com','0565273812','M','Riyadh',0,'ROLE_ADMIN',1),
--  ('ahmad','aljamman','ali77','$2a$10$tYC0.tcXH1xDtqCGR9JC6edQeBTWhXPMQqonF4iM34zFecgxSa23a','ahmad11@hotmail.com','0565273812','M','Riyadh',1,'ROLE_ORGANIZER',1),
--  ('ALI','aljamman','ali88','$2a$10$tYC0.tcXH1xDtqCGR9JC6edQeBTWhXPMQqonF4iM34zFecgxSa23a','ahmad11@hotmail.com','0565273812','F','Riyadh',1,'ROLE_USER',1),
--  ('FFFFF','aljamman','ali99','$2a$10$tYC0.tcXH1xDtqCGR9JC6edQeBTWhXPMQqonF4iM34zFecgxSa23a','ahmad11@hotmail.com','0565273812','M','HHHGG',0,'ROLE_USER',1);
--
--  INSERT INTO Events ( Event_name,City,Description,Capacity,ETime,EDate,Deleting,Approved,Count,event_user_id)
--  VALUES
--  ('nathional day1','Riyadh','descrption of event 1',2,'09:55:00','2018-10-13',0,1,0,2),
--  ('nathional day2','Jeddah','descrption of event 2',3,'08:12:00','2018-11-18',0,1,0,2),
--  ('nathional day3','Dammam','descrption of event 3',300,'08:00:00','2018-11-21',0,1,0,2);
--
-- INSERT INTO Tickets ( Deleting,attend,ticket_user_id,ticket_event_id)
-- VALUES
-- (0,1,1,2),
-- (0,1,2,3);
--
--
--  INSERT INTO Rate (Comments,Rate,Is_delete,review_ticket_id)
-- VALUES
-- ('there are not any empty place ',3,0,1);
