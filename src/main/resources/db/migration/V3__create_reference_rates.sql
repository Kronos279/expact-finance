CREATE TABLE reference_rates (
     currency_code CHAR(3) PRIMARY KEY,
     central_bank VARCHAR(255) NOT NULL,
     rate NUMERIC(5,2) NOT NULL,
     last_updated TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Seed the initial data for the Indian MVP
INSERT INTO reference_rates (currency_code, central_bank, rate)
VALUES ('INR', 'Reserve Bank of India', 6.50);