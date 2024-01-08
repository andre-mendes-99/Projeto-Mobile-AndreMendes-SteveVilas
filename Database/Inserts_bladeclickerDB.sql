use bladeclickerbd;
-- Inserts tabela player
insert into player values(1,"André", "andrezmendes18@gmail.com", "123456789", 200, 99);
insert into player values(2,"Steve", "stevevillas@gmail.com", "123456789", 400, 188);
insert into player values(3,"Kaio", "kaiobrasil@gmail.com", "123456789", 199, 98);
insert into player values(4,"Tester1", "tester@gmail.com", "123456789", 9999, 888);
insert into player values(5,"GOD", "god@gmail.com", "123456789", 999999, 99999);

-- Inserts tabela state
insert into state values(1,"Não Verificado");
insert into state values(2,"Verificado");
insert into state values(3,"Suspenso");

-- Inserts na tabela Achievment_score
insert into achievment_score values(1, "1000 pontos","Conseguir 1000 pontos", false);
insert into achievment_score values(2, "10000 pontos","Conseguir 10000 pontos", false);
insert into achievment_score values(3, "1000000 pontos","Conseguir 100000 pontos", false);

-- Inserts na tabela Achievment_upgrade
insert into achievment_upgrade values(1, "Primeiros Passos","Conseguir a primeira melhoria", false);
insert into achievment_upgrade values(2, "Quase Lá...","Conseguir a segunda melhoria", false);
insert into achievment_upgrade values(3, "Upado ao Maximo","Conseguir todas as melhorias", false);

-- Inserts na tabela upgrades_to_buy
insert into upgrade_to_buy values(1, "Melhoria de Espada", "Melhora a espada, ganha mais pontos a cada toque", 1); -- Nivel 1 é não adquirido
insert into upgrade_to_buy values(2, "Melhoria de aptidão fisica", "O número de toques no ecrã faz com que o multiplicador de pontos aumente", 1); 
insert into upgrade_to_buy values(3, "Melhoria de itens", "Os minijogos dão mais pontos", 1); 


-- Inserts tabela mini_game
insert into mini_game values(1);
insert into mini_game values(2);

-- inserts da tabela player_state
insert into player_state values(1,1,1, curdate());
insert into player_state values(2,2,1, curdate());
insert into player_state values(3,3,1, curdate());
insert into player_state values(4,4,2, curdate());
insert into player_state values(5,5,1, curdate());

-- inserts da tabela player_upgrade
insert into player_upgrade values(1,1,1);
insert into player_upgrade values(2,1,2);
insert into player_upgrade values(3,1,3);
insert into player_upgrade values(4,2,1);
insert into player_upgrade values(5,2,2);
insert into player_upgrade values(6,2,3);
insert into player_upgrade values(7,3,1);
insert into player_upgrade values(8,3,2);
insert into player_upgrade values(9,3,3);
insert into player_upgrade values(10,4,1);
insert into player_upgrade values(11,4,2);
insert into player_upgrade values(12,4,3);
insert into player_upgrade values(13,5,1);
insert into player_upgrade values(14,5,2);
insert into player_upgrade values(15,5,3);

-- inserts da tabela reward
insert into reward values(1,200,1,3); 

-- insert na tabela player_achievment_score
insert into player_achievment_score values(1,1,1); 
insert into player_achievment_score values(2,2,1); 
insert into player_achievment_score values(3,3,1); 
insert into player_achievment_score values(4,4,1); 
insert into player_achievment_score values(5,5,1); 

-- insert na tabela upgrade_achievment_upgrade
insert into upgrade_achievment_upgrade  values(1,1,1); 
insert into upgrade_achievment_upgrade values(2,2,1); 
insert into upgrade_achievment_upgrade values(3,3,1); 
insert into upgrade_achievment_upgrade values(4,3,1); 
insert into upgrade_achievment_upgrade values(5,2,1); 


