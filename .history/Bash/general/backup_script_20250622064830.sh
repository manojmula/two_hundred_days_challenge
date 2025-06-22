#!/bin/bash
src="/home/user/data"
dest="/home/user/backup"
timestamp=$(data + %Y-%m-%d_%H-%M-%S)

mkdir -p "$dest"
cp -r "$src" "$dest/backup_$timestamp"

echo "Backup done!"