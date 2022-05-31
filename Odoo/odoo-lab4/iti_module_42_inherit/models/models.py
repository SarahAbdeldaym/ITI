# -*- coding: utf-8 -*-

from odoo import models, fields, api


class CallLogInheritance(models.Model):
    _name = 'iti.call.log'
    _inherit = 'iti.call.log'
    _description = 'Call Log'

    description = fields.Text()

    @api.depends('value')
    def _value_pc(self):
        for record in self:
            record.value2 = float(record.value) / 100
