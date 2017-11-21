var express = require('express');
var db = require('../db')
var router = express.Router();

//storages/:mem_seq
router.get('/:mem_seq', function(req, res, next){
  var mem_seq = req.params.mem_seq;

  var sql = "select * " +
            "from refrigerator_storages " +
            "where mem_seq = ? ";
  console.log("sql in storages : " + sql);

  db.get().query(sql, mem_seq, function(err,rows){
    if (err){
      res.sendStatus(400);
    }
    console.log("rows : " + JSON.stringify(rows));
    console.log("row.length : " +rows.length);

    res.status(200).json(rows);
  });
});

module.exports = router;
