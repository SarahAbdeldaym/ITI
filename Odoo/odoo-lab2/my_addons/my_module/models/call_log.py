from email.policy import default
from unicodedata import name
from odoo import models, fields, api

""" 
- Create call logs class
- define fields
    customer (M2O)
    timestamp (datetime)
    from (char)
    to (char)
    duration (int)
    price (float)
    package (M2O)
    notes (text)
 """


class Package(models.Model):
    """
        Fields:
        - name (Char)
        - price (Float)
        - type (Selection)
    """

    _name = "iti.package"
    _description = "call packages"

    name = fields.Char()
    price = fields.Float()
    type = fields.Selection(selection=[
        ('unit', 'Unit'),
        ('flex', 'Flex')
    ], default='unit')


class CallLog(models.Model):
    _name = 'iti.call.log'      # Table Name (iti_call_log)
    _description = 'Call log class'
    _rec_name = 'timestamp'

    customer = fields.Char()
    timestamp = fields.Datetime()
    from_number = fields.Char(string="from")
    to_number = fields.Char(string="to")
    duration = fields.Integer()
    price = fields.Float(compute='_compute_price')
    notes = fields.Text()
    package_id = fields. Many2one(comodel_name='iti.package')

    @api.depends('duration', 'package_id.price')
    def _compute_price(self):
        for rec in self:
            rec.price = rec.duration / 60 * rec.package_id.price
