'use strict'
const fs = require('fs');
const packageJSON = require('../package.json');
const upath = require('upath');
const sh = require('shelljs');

module.exports = function renderScripts() {

    //const sourcePath = upath.resolve(upath.dirname(__filename), '../js');
    //const destPath = upath.resolve(upath.dirname(__filename), '../public/js/.');
    
    //sh.cp('-R', sourcePath, destPath)

    const sourcePathScriptsJS = upath.resolve(upath.dirname(__filename), '../js/app.js');
    const destPathScriptsJS = upath.resolve(upath.dirname(__filename), '../public/js/app.js');
    
    const copyright = `/*!
* MStore Ecommerce Site - ${packageJSON.title} v${packageJSON.version} (${packageJSON.homepage})
* Copyright 2021-${new Date().getFullYear()} ${packageJSON.author}
* Licensed under ${packageJSON.license} (https://github.com/maithanhduyan/m-store/blob/master/LICENSE)
*/
`
    const scriptsJS = fs.readFileSync(sourcePathScriptsJS);
    
    fs.writeFileSync(destPathScriptsJS, copyright + scriptsJS);
};