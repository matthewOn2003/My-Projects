require('dotenv').config();
const Pool = require('pg').Pool;

const connectionString =
    `postgresql://${process.env.PGUSER}:${process.env.PGPASSWORD}@${process.env.PGHOST}:${process.env.PGPORT}/${process.env.PGDATABASE}`;

const pool = new Pool({
    connectionString: connectionString,
});

module.exports = {
    query: (text, params) => pool.query(text, params),
    end: () => pool.end(),
};


// const pool = new Pool({
//     user: process.env.PG_USER,
//     host: process.env.PG_HOST,
//     database: process.env.PG_DATABASE,
//     password: process.env.PG_PASSWORD,
//     port: process.env.PG_PORT,
// });