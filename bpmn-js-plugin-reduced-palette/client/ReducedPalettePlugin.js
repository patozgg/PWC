'use strict';



var CustomPaletteProvider = require('./custom/CustomPaletteProvider');

function ReducedPalettePlugin(bpmnjs, contextPad, palette, create, elementFactory, spaceTool, lassoTool, handTool, globalConnect, translate, eventBus, modeling, connect, popupMenu, canvas, rules, bpmnReplace, moddle, replaceMenuProvider) {

    var customPalette = new CustomPaletteProvider(palette, create, elementFactory, spaceTool, lassoTool, handTool, globalConnect, translate);
    palette._providers = [];
    palette.registerProvider(customPalette);

 
}

ReducedPalettePlugin.$inject = [ 'bpmnjs', 'contextPad', 'palette', 'create', 'elementFactory', 'spaceTool', 'lassoTool', 'handTool', 'globalConnect', 'translate', 'eventBus', 'modeling', 'connect', 'popupMenu', 'canvas', 'rules', 'bpmnReplace', 'moddle', 'replaceMenuProvider' ];

module.exports = {
    __init__: ['reducedPalettePlugin'],
    reducedPalettePlugin: ['type', ReducedPalettePlugin]
};
