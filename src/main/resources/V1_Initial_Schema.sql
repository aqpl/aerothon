CREATE TABLE `users` (
    `email` VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL,
    `password` VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL,
    `token` VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL,
    `amount` INT NOT NULL DEFAULT '0',
    `isAdmin` SMALLINT NOT NULL DEFAULT '0',
    PRIMARY KEY (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE INDEX tokens_idx ON users(token);

CREATE TABLE `flights` (
  `flightId` varchar(255) NOT NULL,
  `source` varchar(255) NOT NULL,
  `destination` varchar(255) NOT NULL,
  `startTime` BIGINT NOT NULL,
  `endTime` BIGINT NOT NULL,
    `price` BIGINT NOT NULL,
  `capacity` BIGINT NOT NULL,
  PRIMARY KEY (`flightId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `searches` (
  `email` varchar(255) NOT NULL,
  `source` varchar(255) NOT NULL,
  `destination` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `promotions` (
  `email` varchar(255) NOT NULL,
  `offer` text CHARACTER SET utf8mb4
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `bookings` (
  `bookingId` BIGINT NOT NULL,
  `email` varchar(255) NOT NULL,
  `flightId` varchar(255) NOT NULL,
  `amountPaid` BIGINT NOT NULL,
   PRIMARY KEY (`bookingId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `transactions` (
  `email` BIGINT NOT NULL,
  `txnId` BIGINT NOT NULL,
  `details` text CHARACTER SET utf8mb4,
   PRIMARY KEY (`email`, `txnId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;








