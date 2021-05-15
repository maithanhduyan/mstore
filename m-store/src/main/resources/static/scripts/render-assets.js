  
'use strict';
const fs = require('fs');
const upath = require('upath');
const sh = require('shelljs');

module.exports = function renderAssets() {
    
    // Jquery
    const sourcePath = upath.resolve(upath.dirname(__filename), '../node_modules/jquery/dist/');
    const destPath = upath.resolve(upath.dirname(__filename), '../public/vendor/jquery/.');
    
    sh.cp('-R', sourcePath, destPath)
    console.log("jquery done.");
    

    // Bootstrap
    const sourcePathBootstrap = upath.resolve(upath.dirname(__filename), '../node_modules/bootstrap/dist/');
    const destPathBootstrap = upath.resolve(upath.dirname(__filename), '../public/vendor/bootstrap/.');
    
    sh.cp('-R', sourcePathBootstrap, destPathBootstrap)
    console.log("bootstrap done.");
};