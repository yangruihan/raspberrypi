set nocompatible 

set rtp+=~/.vim/bundle/vundle/
call vundle#rc()

Bundle 'gmarik/vundle'

" my personal settings
if has("syntax")
	syntax on	" 语法高亮
endif
" colorscheme slate

filetype on
filetype plugin on

set background=dark

if has("autocmd")
	au BufReadPost * if line("'\"") > 1 && line("'\"") <= line("$") | exe "normal! g'\"" | endif
	filetype plugin indent on
endif

set ignorecase
set smartcase
set autowrite
set autoindent
set smartindent
set tabstop=4
set softtabstop=4
set shiftwidth=4
set cindent
set cinoptions={0,1s,t0,n-2,p2s,(03s,=.5s,>1s,=1s,:1s
set showmatch
set linebreak
set whichwrap=b,s,<,>,[,]
set mouse=a
set number
set history=100

set laststatus=2
set ruler

set showcmd
set showmode

set incsearch
set hlsearch

set bsdir=buffer
set autochdir

set encoding=utf-8
lang messages zh_CN.UTF-8

source $VIMRUNTIME/delmenu.vim
source $VIMRUNTIME/menu.vim

set fileencodings=cp936,utf-8,ucs-bom.latin1
set fileencoding=utf-8
let &termencoding=&encoding

set nobackup
set gdefault

au BufNewFile,BufRead *.less set filetype=css
au BufNewFile,BufRead *.phtml set filetype=php
au BufRead,BufNewFile *.js set ft=javascript.jquery

au BufRead *.py map <buffer> <F5> :w <CR>:!/usr/bin/env python %<CR>

let g:neocomplcache_enalbe_at_startup=1

Bundle 'tpope/vim-fugitive'
Bundle 'rstacruz/sparkup', {'rtp': 'vim/'}
Bundle 'tpope/vim-rails.git'
Bundle 'Mark'
Bundle 'The-NERD-tree'
Bundle 'matchit.zip'
Bundle 'AutoComplPop'
Bundle 'a.vim'
Bundle 'Align'
Bundle 'ccvext.vim'
Bundle 'bufexplorer.zip'
Bundle 'cSyntaxAfter'

python from powerline.vim import setup as powerline_setup
python powerline_setup()
python del powerline_setup
