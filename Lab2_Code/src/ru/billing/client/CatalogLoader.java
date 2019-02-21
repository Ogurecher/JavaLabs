package ru.billing.client;

import ru.billing.exceptions.CatalogLoadException;
import ru.billing.stocklist.ItemCatalog;

public interface CatalogLoader {
    void load (ItemCatalog catalog) throws CatalogLoadException;
}