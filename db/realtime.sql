USE realtime;

CREATE TABLE IF NOT EXISTS `trans` (
  `trans_id` int(11) NOT NULL AUTO_INCREMENT,
  `received_id` int(50) NOT NULL,
  `sender_id` int(50) NOT NULL,
  `amount` int(50) NOT NULL,
  `date` varchar(50) NOT NULL,
  PRIMARY KEY (`trans_id`)
);



CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `balance` int(50) NOT NULL,
  PRIMARY KEY (`user_id`)
);


INSERT INTO `users` (`user_id`, `name`, `phone`, `pass`, `balance`) VALUES
(1, 'user1', '00489099263', '12345', 0);
