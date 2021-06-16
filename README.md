# Example-LoginPage-SpringSecurity
Sistema web simples de acesso a recursos controlados por login (Roles).
Neste exemplo, 2 usuários em mémoria foram criados.

User: renan
Password: renan
Role: ADMIN

User: aline
Password: aline
Role: USER

O usuário de Role ADMIN consegue acessar todas as páginas, incluindo a user.html, pois tem acesso a mesma.
O usuário de Role USER só consegue acessar a página user.html, pois não tem acesso a página admin.html
