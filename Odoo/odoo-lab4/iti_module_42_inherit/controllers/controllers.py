# -*- coding: utf-8 -*-
# from odoo import http


# class ItiModule42Inherit(http.Controller):
#     @http.route('/iti_module_42_inherit/iti_module_42_inherit', auth='public')
#     def index(self, **kw):
#         return "Hello, world"

#     @http.route('/iti_module_42_inherit/iti_module_42_inherit/objects', auth='public')
#     def list(self, **kw):
#         return http.request.render('iti_module_42_inherit.listing', {
#             'root': '/iti_module_42_inherit/iti_module_42_inherit',
#             'objects': http.request.env['iti_module_42_inherit.iti_module_42_inherit'].search([]),
#         })

#     @http.route('/iti_module_42_inherit/iti_module_42_inherit/objects/<model("iti_module_42_inherit.iti_module_42_inherit"):obj>', auth='public')
#     def object(self, obj, **kw):
#         return http.request.render('iti_module_42_inherit.object', {
#             'object': obj
#         })
