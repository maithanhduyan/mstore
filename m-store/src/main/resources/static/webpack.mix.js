 const mix = require('laravel-mix');
 const upath = require('upath');
/*
 |--------------------------------------------------------------------------
 | Mix Asset Management
 |--------------------------------------------------------------------------
 |
 | Mix provides a clean, fluent API for defining some Webpack build steps
 | for your Laravel application. By default, we are compiling the Sass
 | file for the application as well as bundling up all the JS files.
 |
 */

//  const sourcePathScriptsJS = upath.resolve(upath.dirname(__filename), '../static/js/app.js');
//  const destPathScriptsJS = upath.resolve(upath.dirname(__filename), '../static/public/js/app.js');

   // webpack.mix.js


mix.js('../static/js/app.js', '/public/js');
