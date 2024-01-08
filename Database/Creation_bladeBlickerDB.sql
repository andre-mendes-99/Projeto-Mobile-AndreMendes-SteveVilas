use bladeclickerbd;
create table player(
player_id int not null auto_increment,
player_playername varchar(200) not null,
player_email varchar(100) not null,
player_password varchar(100) not null,
player_score double,
player_taps int,
primary key(player_id)
);


create table state(
state_id int not null auto_increment,
state_name varchar(50) not null,
primary key(state_id)
);

create table player_state(
player_state_id int not null auto_increment,
player_state_player_id int not null,
player_state_state_id int not null,
player_sate_date datetime not null,
primary key(player_state_id)
);

create table achievment_score(
achievment_score_id int not null auto_increment,
achievment_score_title varchar(100) not null,
achievment_score_description varchar(500) not null,
primary key(achievment_score_id)
);

create table player_achievment_score(
player_achievment_score_id int not null auto_increment,
player_achievment_score_player_id int not null,
player_achievment_score_achievment_score_id int not null,
primary key(player_achievment_score_id)
);

create table upgrade_to_buy(
upgrade_id int not null auto_increment,
upgrade_title varchar(100) not null,
upgrade_description varchar(500) not null,
upgrade_level int not null,
primary key(upgrade_id));

create table player_upgrade(
player_upgrade_id int not null auto_increment,
player_upgrade_player_id int not null,
player_upgrade_upgrade_id int not null,
primary key(player_upgrade_id));

create table achievment_upgrade(
achievment_upgrade_id int not null auto_increment,
achievment_upgrade_title varchar(100) not null,
achievment_upgrade_description varchar(500) not null,
primary key(achievment_upgrade_id)
);



create table upgrade_achievment_upgrade(
upgrade_achievment_upgrade_id int not null auto_increment,
upgrade_achievment_upgrade_upgrade_id int not null,
upgrade_achievment_upgrade_achievment_upgrade_id int not null,
primary key(upgrade_achievment_upgrade_id)
);

create table reward(
reward_id int not null auto_increment,
reward_points double,
reward_mini_game_id int not null,
reward_upgrade_id int not null,
primary key(reward_id)
);

create table mini_game(
mini_game_id int not null auto_increment,
primary key(mini_game_id)
);

#foreign keys
alter table player_achievment_score 
add constraint player_fk_achievment_score
foreign key (player_achievment_score_player_id) references player(player_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table  player_state
add constraint player_state_fk_achievment_player
foreign key (player_state_player_id) references player(player_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table  player_state
add constraint player_state_fk_achievment_state
foreign key (player_state_state_id) references state(state_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table player_upgrade 
add constraint player_fk_player_upgrade
foreign key (player_upgrade_player_id) references player(player_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table player_upgrade 
add constraint upgrade_fk_player_upgrade
foreign key (player_upgrade_upgrade_id) references upgrade_to_buy(upgrade_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table upgrade_achievment_upgrade 
add constraint upgrade_fk_achievment_upgrade
foreign key (upgrade_achievment_upgrade_upgrade_id) references upgrade_to_buy(upgrade_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table upgrade_achievment_upgrade 
add constraint upgrade_fk_achievment_upgrade_achievment
foreign key (upgrade_achievment_upgrade_achievment_upgrade_id) references achievment_upgrade(achievment_upgrade_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table reward 
add constraint reward_fk_mini_game
foreign key (reward_mini_game_id) references mini_game(mini_game_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table reward 
add constraint reward_fk_upgrades
foreign key (reward_upgrade_id) references upgrade_to_buy(upgrade_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;