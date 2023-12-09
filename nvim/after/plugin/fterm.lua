require'FTerm'.setup({
    border = 'double',
    dimensions  = {
        height = 0.8,
        width = 0.3,
        x = 1,
        y = .0
    }
})

vim.keymap.set('n', '<C-u>', '<CMD>lua require("FTerm").toggle()<CR>')
vim.keymap.set('t', '<C-u>', '<C-\\><C-n><CMD>lua require("FTerm").toggle()<CR>')
