const fs = require('fs');
const sh = require('shelljs');
const upath = require('upath');

var publicDir = './public';
if (!fs.existsSync(publicDir)){
    fs.mkdirSync(publicDir);
}

var vendorDir = './public/vendor';
if (!fs.existsSync(vendorDir)){
    fs.mkdirSync(vendorDir);
}

var cssDir = './public/css';
if (!fs.existsSync(cssDir)){
    fs.mkdirSync(cssDir);
}

var jsDir = './public/js';
if (!fs.existsSync(jsDir)){
    fs.mkdirSync(jsDir);
}

const destPath = upath.resolve(upath.dirname(__filename), '../public/vendor');

sh.rm('-rf', `${vendorDir}/*`);
sh.rm('-rf', `${cssDir}/*`);
sh.rm('-rf', `${jsDir}/*`);

console.log("Clean done.");